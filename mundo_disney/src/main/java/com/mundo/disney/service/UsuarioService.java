package com.mundo.disney.service;

import com.mundo.disney.persistencia.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> getUserById(int usernameId);
    Optional<Usuario> getUserByUsername(String username);
    Usuario save(Usuario usuario);
    boolean delete(Integer usernameId);


}
