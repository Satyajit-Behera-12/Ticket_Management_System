package com.example.ticket.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;   // Bug, Payment, Access
    private String priority;   // LOW, MEDIUM, HIGH
    private String status;     // OPEN, IN_PROGRESS, CLOSED

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
