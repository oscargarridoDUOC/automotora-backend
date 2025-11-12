package com.example.automotora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.automotora.model.Marca;
import com.example.automotora.repository.MarcaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    public Marca getMarcaById(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Optional<Marca> getMarcasByNombre(String nombre) {
        return marcaRepository.findByNombre(nombre);
    }

    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    } 

    public void deleteMarca(Integer id) {
        marcaRepository.deleteById(id);

        //TODO: VERIFICAR CASCADE
    }

    //TODO: CREAR UPDATE MARCA

    //TODO: CREAR PATCH MARCA

}
