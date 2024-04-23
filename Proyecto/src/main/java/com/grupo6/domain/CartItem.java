/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.domain;

import jakarta.persistence.*;
import java.io.Serializable;
/**
 *
 * @author Morgan
 */
@Entity
@Table(name = "CartItems")
public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "implemento_id", referencedColumnName = "id")
    private Implemento implemento;

    @ManyToOne
    @JoinColumn(name = "suplemento_id", referencedColumnName = "id")
    private Suplemento suplemento;

    @ManyToOne
    @JoinColumn(name = "vestimenta_id", referencedColumnName = "id")
    private Vestimenta vestimenta;

    public CartItem() {

    }

    public CartItem(Long id, Implemento implemento, Suplemento suplemento, Vestimenta vestimenta) {
        this.id = id;
        this.implemento = implemento;
        this.suplemento = suplemento;
        this.vestimenta = vestimenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Implemento getImplemento() {
        return implemento;
    }

    public void setImplemento(Implemento implemento) {
        this.implemento = implemento;
    }

    public Suplemento getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(Suplemento suplemento) {
        this.suplemento = suplemento;
    }

    public Vestimenta getVestimenta() {
        return vestimenta;
    }

    public void setVestimenta(Vestimenta vestimenta) {
        this.vestimenta = vestimenta;
    }
}
