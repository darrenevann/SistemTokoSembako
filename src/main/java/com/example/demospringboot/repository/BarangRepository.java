package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangRepository extends JpaRepository<Barang, String> {

    List<Barang> findByIsActiveTrue();

}