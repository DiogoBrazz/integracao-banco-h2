package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ColaboradorEntity;
import com.repository.ColaboradorRepository;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public ColaboradorEntity salvarColaborador(ColaboradorEntity colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public List<ColaboradorEntity> listarColaboradores() {
        return colaboradorRepository.findAll();
    }

    public ColaboradorEntity buscarColaboradorPorId(Long id) {
        return colaboradorRepository.findById(id).orElse(null);
    }

    public void excluirColaborador(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
