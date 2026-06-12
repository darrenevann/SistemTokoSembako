package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
public class Stok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStok;

    @OneToOne
    @JoinColumn(name = "id_barang")
    private Barang barang;

    private Integer jumlahStok;

    public Stok() {
    }

    public Long getIdStok() {
        return idStok;
    }

    public void setIdStok(Long idStok) {
        this.idStok = idStok;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getJumlahStok() {
        return jumlahStok;
    }

    public void setJumlahStok(Integer jumlahStok) {
        this.jumlahStok = jumlahStok;
    }
}