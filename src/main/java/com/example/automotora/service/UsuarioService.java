package com.example.automotora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import com.example.automotora.model.Usuario;
import com.example.automotora.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }

    public Usuario update(Long id, Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioToUpdate = optionalUsuario.get();
            usuarioToUpdate.setNombre(usuario.getNombre());
            usuarioToUpdate.setCorreo(usuario.getCorreo());
            usuarioToUpdate.setRut(usuario.getRut());
            usuarioToUpdate.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioToUpdate.setRol(usuario.getRol());
            return usuarioRepository.save(usuarioToUpdate);
        } else {
            return null;
        }
    }

    public Usuario patch(Long id, Usuario usuarioParcial) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioToUpdate = optionalUsuario.get();

            if (usuarioParcial.getNombre() != null) {
                usuarioToUpdate.setNombre(usuarioParcial.getNombre());
            }
            if (usuarioParcial.getCorreo() != null) {
                usuarioToUpdate.setCorreo(usuarioParcial.getCorreo());
            }
            if (usuarioParcial.getRut() != null) {
                usuarioToUpdate.setRut(usuarioParcial.getRut());
            }
            if (usuarioParcial.getFechaNacimiento() != null) {
                usuarioToUpdate.setFechaNacimiento(usuarioParcial.getFechaNacimiento());
            }
            if (usuarioParcial.getRol() != null) {
                usuarioToUpdate.setRol(usuarioParcial.getRol());
            }

            return usuarioRepository.save(usuarioToUpdate);
        } else {
            return null;
        }
    }
}
