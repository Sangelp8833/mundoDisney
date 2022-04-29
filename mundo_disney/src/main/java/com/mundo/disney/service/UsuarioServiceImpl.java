package com.mundo.disney.service;

import com.mundo.disney.persistencia.entities.Usuario;
import com.mundo.disney.persistencia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> getUserById(int usernameId) {
        return usuarioRepository.findById(usernameId);
    }

    @Override
    public Optional<Usuario> getUserByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean delete(Integer usernameId) {
        return getUserById(usernameId).map(u -> {
            usuarioRepository.delete(u);
            return true;
        }).orElse(false);
    }
}
