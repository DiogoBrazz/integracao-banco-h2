package com.controller;

import com.entity.TicketEntity;
import com.entity.TicketEntity.Situacao;
import com.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/tickets")
@CrossOrigin("*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<TicketEntity> listarTickets() {
        return ticketService.listarTickets();
    }
    
    @PostMapping
    public TicketEntity salvarTicket(@RequestBody TicketEntity ticket) {
        return ticketService.salvarTicket(ticket);
    }

    @GetMapping("/{id}")
    public TicketEntity buscarTicketPorId(@PathVariable Long id) {
        return ticketService.buscarTicketPorId(id);
    }

    @PutMapping("/{id}")
    public TicketEntity atualizarTicket(@PathVariable Long id, @RequestBody TicketEntity ticket) {
        ticket.setId(id);
        return ticketService.salvarTicket(ticket);
    }

    @DeleteMapping("/{id}")
    public void excluirTicket(@PathVariable Long id) {
        ticketService.excluirTicket(id);
    }

    @GetMapping("/situacao/{situacao}")
    public List<TicketEntity> listarTicketsPorSituacao(@PathVariable Situacao situacao) {
        return ticketService.listarTicketsPorSituacao(situacao);
    }

    @GetMapping("/contar/atendidos")
    public long contarTicketsAtendidos() {
        return ticketService.contarTicketsAtendidos();
    }

    @GetMapping("/contar/abertos")
    public long contarTicketsAbertos() {
        return ticketService.contarTicketsAbertos();
    }
}
