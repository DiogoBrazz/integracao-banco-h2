package com.controller;

import com.entity.EnderecoEntity;
import com.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/enderecos")
@CrossOrigin("*")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoEntity> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @PostMapping
    public EnderecoEntity criarEndereco(@RequestBody EnderecoEntity endereco) {
        return enderecoService.salvarEndereco(endereco);
    }

    @GetMapping("/{id}")
    public EnderecoEntity buscarEndereco(@PathVariable Long id) {
        return enderecoService.buscarEnderecoPorId(id);
    }

    @PutMapping("/{id}")
    public EnderecoEntity atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoEntity endereco) {
        endereco.setId(id);
        return enderecoService.salvarEndereco(endereco);
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable Long id) {
        enderecoService.excluirEndereco(id);
    }
}
