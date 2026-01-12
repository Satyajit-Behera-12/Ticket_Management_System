package com.example.ticket.controller;

import com.example.ticket.dto.TicketRequestDTO;
import com.example.ticket.model.Ticket;
import com.example.ticket.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;
    
    @GetMapping("/test")
    public String test() {
        return "API WORKING";
    }

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody TicketRequestDTO dto) {
        return ticketService.createTicket(dto);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PutMapping("/{id}/status")
    public Ticket updateStatus(@PathVariable Long id,
                               @RequestParam String status) {
        return ticketService.updateStatus(id, status);
    }
}
