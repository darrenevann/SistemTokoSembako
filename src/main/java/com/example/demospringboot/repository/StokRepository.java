package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Barang;
import com.example.demospringboot.entity.Stok;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StokRepository
        extends JpaRepository<Stok, Long> {

    // Cari stok berdasarkan barang
    Stok findByBarang(
            Barang barang);

    // Cari barang dengan stok <= jumlah tertentu
    List<Stok> findByJumlahStokLessThanEqual(
            Integer jumlahStok);

}