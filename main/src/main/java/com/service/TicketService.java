package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.TicketEntity;
import com.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketEntity salvarTicket(TicketEntity ticket) {
        return ticketRepository.save(ticket);
    }

    public List<TicketEntity> listarTickets() {
        return ticketRepository.findAll();
    }

    public TicketEntity buscarTicketPorId(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public void excluirTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public List<TicketEntity> listarTicketsPorSituacao(TicketEntity.Situacao situacao) {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getSituacao() == situacao)
                .toList();
    }

    public long contarTicketsAtendidos() {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getSituacao() == TicketEntity.Situacao.ATENDIDO)
                .count();
    }

    public long contarTicketsAbertos() {
        return ticketRepository.findAll().size();
    }
}
