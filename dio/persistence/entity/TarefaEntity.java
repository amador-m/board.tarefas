package br.com.dio.persistence.entity;

public class TarefaEntity {
    private Long id;
    private String descricao;
    private StatusTarefa status;
    private UsuarioEntity responsavel;

    public TarefaEntity(Long id, String descricao, UsuarioEntity responsavel) {
        this.id = id;
        this.descricao = descricao;
        this.status = StatusTarefa.PENDENTE;
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public UsuarioEntity getResponsavel() {
        return responsavel;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TarefaEntity{id=" + id + ", descricao='" + descricao + "', status=" + status + 
               ", responsavel=" + (responsavel != null ? responsavel.getNome() : "Nenhum") + "}";
    }
}
