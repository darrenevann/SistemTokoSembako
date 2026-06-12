package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
public class Pembayaran {

    @Id
    private String idPembayaran;


    @OneToOne
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

    public Pembayaran() {
    }

    // Getter Setter
}