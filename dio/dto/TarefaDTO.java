package br.com.dio.dto;

public class TarefaDTO {
    private String descricao;

    public TarefaDTO(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
