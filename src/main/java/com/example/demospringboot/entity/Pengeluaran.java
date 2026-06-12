package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Pengeluaran {

    @Id
    private String idPengeluaran;

    private Date tanggal;

    private String keterangan;

    private Float nominal;

    public String getIdPengeluaran() {
        return idPengeluaran;
    }

    public void setIdPengeluaran(String idPengeluaran) {
        this.idPengeluaran = idPengeluaran;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Float getNominal() {
        return nominal;
    }

    public void setNominal(Float nominal) {
        this.nominal = nominal;
    }
}