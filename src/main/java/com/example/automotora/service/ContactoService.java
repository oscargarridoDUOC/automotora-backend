package com.example.automotora.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.automotora.model.Contacto;
import com.example.automotora.repository.ContactoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> getAllContactos() {
        return contactoRepository.findAll();
    }

    public Contacto getContactoById(Integer id) {
        return contactoRepository.findById(id).orElse(null);
    }

    public Contacto saveContacto(Contacto contacto) {
        contacto.setFechaCreacion(Instant.now());
        return contactoRepository.save(contacto);
    }

    public void deleteContacto(Integer id) {
        contactoRepository.deleteById(id);
    }
}
