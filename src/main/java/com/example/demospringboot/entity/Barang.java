package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Barang {

    @Id
    private String idBarang;

    private String namaBarang;

    private Float hargaModal;

    private Float hargaSatuan;

    private String kategori;

    private String gambar;

    private Boolean isActive = true;

    public Barang() {
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Float getHargaModal() {
        return hargaModal;
    }

    public void setHargaModal(Float hargaModal) {
        this.hargaModal = hargaModal;
    }

    public Float getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(Float hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}