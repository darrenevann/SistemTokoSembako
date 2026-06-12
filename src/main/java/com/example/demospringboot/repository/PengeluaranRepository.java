package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Pengeluaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PengeluaranRepository
        extends JpaRepository<Pengeluaran,String> {

    @Query("""
        SELECT COALESCE(SUM(p.nominal),0)
        FROM Pengeluaran p
    """)
    Float totalPengeluaran();
}