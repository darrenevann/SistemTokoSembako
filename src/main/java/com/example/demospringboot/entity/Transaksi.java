package com.example.demospringboot.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Transaksi {

    @Id
    private String idTransaksi;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalTransaksi;

    private Integer kuantitas;

    private Float totalHarga;

    private String metodePembayaran;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan")
    private Pelanggan pelanggan;

    @ManyToOne
    @JoinColumn(name = "id_barang")
    private Barang barang;

    public Transaksi() {
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public Integer getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(Integer kuantitas) {
        this.kuantitas = kuantitas;
    }

    public Float getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Float totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }
}