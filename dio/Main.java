package br.com.dio;

import br.com.dio.dto.TarefaDTO;
import br.com.dio.persistence.dao.TarefaDAO;
import br.com.dio.persistence.dao.UsuarioDAO;
import br.com.dio.persistence.entity.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TarefaDAO tarefaDAO = new TarefaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Criar novo usuário");
            System.out.println("4. Listar usuários");
            System.out.println("5. Atualizar status de uma tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite o ID do usuário responsável (ou 0 para nenhum): ");
                    long idResp = scanner.nextLong();
                    scanner.nextLine();
                    UsuarioEntity responsavel = null;
                    if (idResp != 0) {
                        responsavel = usuarioDAO.listar().stream()
                                .filter(u -> u.getId().equals(idResp))
                                .findFirst().orElse(null);
                    }
                    TarefaDTO dto = new TarefaDTO(descricao);
                    long idTarefa = tarefaDAO.listar().size() + 1;
                    TarefaEntity novaTarefa = new TarefaEntity(idTarefa, dto.getDescricao(), responsavel);
                    tarefaDAO.salvar(novaTarefa);
                    System.out.println("Tarefa criada com sucesso!");
                    break;
                case 2:
                    List<TarefaEntity> tarefas = tarefaDAO.listar();
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (TarefaEntity tarefa : tarefas) {
                            System.out.println(tarefa);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    long idUsuario = usuarioDAO.listar().size() + 1;
                    UsuarioEntity usuario = new UsuarioEntity(idUsuario, nome);
                    usuarioDAO.salvar(usuario);
                    System.out.println("Usuário criado com sucesso!");
                    break;
                case 4:
                    List<UsuarioEntity> usuarios = usuarioDAO.listar();
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        for (UsuarioEntity u : usuarios) {
                            System.out.println(u);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Digite o ID da tarefa: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    try {
                        TarefaEntity tarefa = tarefaDAO.buscarPorId(id);
                        System.out.println("Status atual: " + tarefa.getStatus());
                        System.out.println("Escolha novo status: 1-PENDENTE, 2-EM_ANDAMENTO, 3-CONCLUIDA");
                        int statusOpcao = scanner.nextInt();
                        scanner.nextLine();
                        switch (statusOpcao) {
                            case 1: tarefa.setStatus(StatusTarefa.PENDENTE); break;
                            case 2: tarefa.setStatus(StatusTarefa.EM_ANDAMENTO); break;
                            case 3: tarefa.setStatus(StatusTarefa.CONCLUIDA); break;
                            default: System.out.println("Opção inválida."); continue;
                        }
                        System.out.println("Status atualizado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
