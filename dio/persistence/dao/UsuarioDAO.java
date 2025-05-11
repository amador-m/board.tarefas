package br.com.dio.persistence.dao;

import br.com.dio.persistence.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<UsuarioEntity> usuarios = new ArrayList<>();

    public void salvar(UsuarioEntity usuario) {
        usuarios.add(usuario);
    }

    public List<UsuarioEntity> listar() {
        return usuarios;
    }
}
