package com.example.demospringboot.service;

import com.example.demospringboot.entity.Pelanggan;
import com.example.demospringboot.repository.PelangganRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PelangganService {

    @Autowired
    private PelangganRepository pelangganRepository;

    public List<Pelanggan> getAllPelanggan() {

        return pelangganRepository.findAll();

    }

    public Pelanggan getPelangganById(
            String id) {

        return pelangganRepository
                .findById(id)
                .orElse(null);

    }

public void addPelanggan(
        Pelanggan pelanggan) {

    long jumlahPelanggan =
            pelangganRepository.count() + 1;

    String idPelangganBaru =
            String.format(
                    "P%03d",
                    jumlahPelanggan);

    pelanggan.setIdPelanggan(
            idPelangganBaru);

    pelangganRepository.save(
            pelanggan);

}

    public void deletePelanggan(
            String id) {

        pelangganRepository.deleteById(
                id);

    }
}