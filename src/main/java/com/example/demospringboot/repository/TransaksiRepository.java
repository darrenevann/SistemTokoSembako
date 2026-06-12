package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Transaksi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaksiRepository
        extends JpaRepository<Transaksi, String> {

    @Query("""
           SELECT COALESCE(SUM(t.totalHarga),0)
           FROM Transaksi t
           """)
    Float getOmsetKotor();

    @Query("""
        SELECT t.barang.namaBarang,
               SUM(t.kuantitas)

        FROM Transaksi t

        GROUP BY t.barang.namaBarang

        ORDER BY SUM(t.kuantitas) DESC
    """)
    List<Object[]> getProdukTerlaris();

    @Query("""
        SELECT MONTH(t.tanggalTransaksi),
               COUNT(t)

        FROM Transaksi t

        GROUP BY MONTH(t.tanggalTransaksi)

        ORDER BY MONTH(t.tanggalTransaksi)
    """)
    List<Object[]> getGrafikPenjualan();



    @Query("""
    SELECT COALESCE(
    SUM(
    (t.barang.hargaSatuan - t.barang.hargaModal)
    * t.kuantitas
    )
    ,0)
    FROM Transaksi t
    """)
    Float getLabaBersih();
}