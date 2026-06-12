package com.example.demospringboot.service;

import com.example.demospringboot.entity.Barang;
import com.example.demospringboot.entity.Stok;

import com.example.demospringboot.repository.BarangRepository;
import com.example.demospringboot.repository.StokRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private StokRepository stokRepository;

    // ==========================
    // GET ALL BARANG
    // ==========================

    public List<Barang> getAllBarang() {

        return barangRepository.findByIsActiveTrue();

    }

    // ==========================
    // GET BARANG BY ID
    // ==========================

    public Barang getBarangById(
            String id) {

        return barangRepository
                .findById(id)
                .orElse(null);

    }

    // ==========================
    // ADD BARANG
    // ==========================

public void addBarang(
        Barang barang) {

    // Generate ID Barang Otomatis
    long jumlahBarang =
            barangRepository.count() + 1;

    String idBarangBaru =
            String.format(
                    "B%03d",
                    jumlahBarang);

    barang.setIdBarang(
            idBarangBaru);

    barang.setIsActive(
            true);

    barangRepository.save(
            barang);

    // Otomatis buat stok
    Stok stok = new Stok();

    stok.setBarang(
            barang);

    stok.setJumlahStok(
            0);

    stokRepository.save(
            stok);

}

    // ==========================
    // UPDATE BARANG
    // ==========================

    public void updateBarang(
            String id,
            Barang barang) {

        Barang oldBarang =
                barangRepository
                        .findById(id)
                        .orElse(null);

        if (oldBarang != null) {

            oldBarang.setNamaBarang(
                    barang.getNamaBarang());

            oldBarang.setHargaModal(
                    barang.getHargaModal());

            oldBarang.setHargaSatuan(
                    barang.getHargaSatuan());

            oldBarang.setKategori(
                    barang.getKategori());

            barangRepository.save(
                    oldBarang);

        }

    }

    // ==========================
    // DELETE BARANG (SOFT DELETE)
    // ==========================

    public void deleteBarang(
            String id) {

        Barang barang =
                barangRepository
                        .findById(id)
                        .orElse(null);

        if (barang != null) {

            barang.setIsActive(false);

            barangRepository.save(
                    barang);

        }

    }

}