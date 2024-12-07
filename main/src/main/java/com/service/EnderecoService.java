package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.EnderecoEntity;
import com.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoEntity salvarEndereco(EnderecoEntity endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<EnderecoEntity> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public EnderecoEntity buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public void excluirEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
