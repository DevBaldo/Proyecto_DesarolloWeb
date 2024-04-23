/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.domain;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author taraz
 */
@Entity
@Table(name = "Reviews")
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private int rating;
    
    @ManyToOne
    @JoinColumn(name = "implemento_id", referencedColumnName = "id")
    private Implemento implemento;
    
    public Implemento getImplemento() {
        return implemento;
    }

    public void setImplemento(Implemento implemento) {
        this.implemento = implemento;
    }
    
    @ManyToOne
    @JoinColumn(name = "suplemento_id", referencedColumnName = "id")
    private Suplemento suplemento;
    
    public Suplemento getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(Suplemento suplemento) {
        this.suplemento = suplemento;
    }
    
    @ManyToOne
    @JoinColumn(name = "vestimenta_id", referencedColumnName = "id")
    private Vestimenta vestimenta;
    
    public Vestimenta getVestimenta() {
        return vestimenta;
    }

    public void setVestimenta(Vestimenta vestimenta) {
        this.vestimenta = vestimenta;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public Review(){
        
    }

    public Review(Long id, String content, int rating) {
        this.id = id;
        this.content = content;
        this.rating = rating;
    }
}
