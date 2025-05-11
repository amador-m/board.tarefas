package br.com.dio.persistence.dao;

import br.com.dio.persistence.entity.TarefaEntity;
import br.com.dio.exception.TarefaNaoEncontradaException;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    private List<TarefaEntity> tarefas = new ArrayList<>();

    public void salvar(TarefaEntity tarefa) {
        tarefas.add(tarefa);
    }

    public List<TarefaEntity> listar() {
        return tarefas;
    }

    public TarefaEntity buscarPorId(Long id) {
        return tarefas.stream()
            .filter(t -> t.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new TarefaNaoEncontradaException("Tarefa com ID " + id + " não encontrada."));
    }
}
