package br.com.dio.persistence.entity;

public class UsuarioEntity {
    private Long id;
    private String nome;

    public UsuarioEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{id=" + id + ", nome='" + nome + "'}";
    }
}
