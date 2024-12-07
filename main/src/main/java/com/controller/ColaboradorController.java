package com.controller;

import com.entity.ColaboradorEntity;
import com.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/colaboradores")
@CrossOrigin("*")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public List<ColaboradorEntity> listarColaboradores() {
        return colaboradorService.listarColaboradores();
    }

    @PostMapping
    public ColaboradorEntity criarColaborador(@RequestBody ColaboradorEntity colaborador) {
        return colaboradorService.salvarColaborador(colaborador);
    }

    @GetMapping("/{id}")
    public ColaboradorEntity buscarColaborador(@PathVariable Long id) {
        return colaboradorService.buscarColaboradorPorId(id);
    }

    @PutMapping("/{id}")
    public ColaboradorEntity atualizarColaborador(@PathVariable Long id, @RequestBody ColaboradorEntity colaborador) {
        colaborador.setId(id);
        return colaboradorService.salvarColaborador(colaborador);
    }

    @DeleteMapping("/{id}")
    public void deletarColaborador(@PathVariable Long id) {
        colaboradorService.excluirColaborador(id);
    }
}
