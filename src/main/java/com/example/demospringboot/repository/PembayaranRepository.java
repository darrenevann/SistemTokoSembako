package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PembayaranRepository
        extends JpaRepository<Pembayaran, String> {

}