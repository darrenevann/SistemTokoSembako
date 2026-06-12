package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
public class DetailTransaksi {

    @Id
    private String idDetail;

    private Integer kuantitas;

    private Float subtotal;

    @ManyToOne
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

    @ManyToOne
    @JoinColumn(name = "id_barang")
    private Barang barang;

    public DetailTransaksi() {
    }

    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    public Integer getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(Integer kuantitas) {
        this.kuantitas = kuantitas;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }
}