package com.controller;

import com.entity.ClienteEntity;
import com.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public ClienteEntity criarCliente(@RequestBody ClienteEntity cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping("/{id}")
    public ClienteEntity buscarCliente(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @PutMapping("/{id}")
    public ClienteEntity atualizarCliente(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        cliente.setId(id);
        return clienteService.salvarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }
}
