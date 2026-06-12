package com.example.demospringboot.repository;

import com.example.demospringboot.entity.DetailTransaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailTransaksiRepository
        extends JpaRepository<DetailTransaksi,String> {

    @Query("""
        SELECT d.barang.namaBarang,
               SUM(d.kuantitas)

        FROM DetailTransaksi d

        GROUP BY d.barang.namaBarang

        ORDER BY SUM(d.kuantitas) DESC
    """)
    List<Object[]> produkTerlaris();
}