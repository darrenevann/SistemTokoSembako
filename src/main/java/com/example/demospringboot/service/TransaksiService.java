package com.example.demospringboot.service;

import com.example.demospringboot.entity.Barang;
import com.example.demospringboot.entity.Pelanggan;
import com.example.demospringboot.entity.Stok;
import com.example.demospringboot.entity.Transaksi;

import com.example.demospringboot.repository.StokRepository;
import com.example.demospringboot.repository.TransaksiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private StokRepository stokRepository;

    @Autowired
    private BarangService barangService;

    @Autowired
    private PelangganService pelangganService;

    // ==========================
    // GET ALL TRANSAKSI
    // ==========================

    public List<Transaksi> getAllTransaksi() {

        return transaksiRepository.findAll();

    }

    // ==========================
    // GET TRANSAKSI BY ID
    // ==========================

    public Transaksi getTransaksiById(
            String id) {

        return transaksiRepository
                .findById(id)
                .orElse(null);

    }

    // ==========================
    // SIMPAN TRANSAKSI
    // ==========================

public void addTransaksi(
        Transaksi transaksi) {

    // ==========================
    // GENERATE ID TRANSAKSI
    // ==========================

    long jumlahTransaksi =
            transaksiRepository.count() + 1;

    String idTransaksiBaru =
            String.format(
                    "TR%03d",
                    jumlahTransaksi);

    transaksi.setIdTransaksi(
            idTransaksiBaru);

    // ==========================
    // AMBIL BARANG DARI DATABASE
    // ==========================

    Barang barang =
            barangService.getBarangById(
                    transaksi.getBarang()
                            .getIdBarang());

    if (barang == null) {

        throw new RuntimeException(
                "Barang tidak ditemukan");

    }

    transaksi.setBarang(
            barang);

    // ==========================
    // AMBIL PELANGGAN DARI DATABASE
    // ==========================

    Pelanggan pelanggan =
            pelangganService.getPelangganById(
                    transaksi.getPelanggan()
                            .getIdPelanggan());

    if (pelanggan == null) {

        throw new RuntimeException(
                "Pelanggan tidak ditemukan");

    }

    transaksi.setPelanggan(
            pelanggan);

    // ==========================
    // CEK STOK
    // ==========================

    Stok stok =
            stokRepository.findByBarang(
                    barang);

    if (stok == null) {

        throw new RuntimeException(
                "Stok tidak ditemukan");

    }

    // ==========================
    // CEK JUMLAH STOK
    // ==========================

    if (stok.getJumlahStok()
            < transaksi.getKuantitas()) {

        throw new RuntimeException(
                "Stok tidak mencukupi. Stok tersedia : "
                        + stok.getJumlahStok());

    }

    // ==========================
    // HITUNG TOTAL HARGA
    // ==========================

    Float totalHarga =
            barang.getHargaSatuan()
                    * transaksi.getKuantitas();

    transaksi.setTotalHarga(
            totalHarga);

    // ==========================
    // KURANGI STOK
    // ==========================

    stok.setJumlahStok(
            stok.getJumlahStok()
                    - transaksi.getKuantitas());

    stokRepository.save(
            stok);

    // ==========================
    // SIMPAN TRANSAKSI
    // ==========================

    transaksiRepository.save(
            transaksi);

}

    // ==========================
    // DELETE TRANSAKSI
    // ==========================

    public void deleteTransaksi(
            String id) {

        transaksiRepository.deleteById(
                id);

    }

}