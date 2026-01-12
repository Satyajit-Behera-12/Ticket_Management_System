package com.example.ticket.service;

import com.example.ticket.dto.TicketRequestDTO;
import com.example.ticket.model.Ticket;
import com.example.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(TicketRequestDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setCategory(dto.getCategory());
        ticket.setPriority(dto.getPriority());
        ticket.setStatus("OPEN");
        ticket.setCreatedAt(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket updateStatus(Long id, String status) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }
}
