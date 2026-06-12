package com.example.demospringboot.service;

import com.example.demospringboot.entity.Stok;
import com.example.demospringboot.repository.StokRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StokService {

    @Autowired
    private StokRepository stokRepository;

    // =====================
    // GET ALL
    // =====================

    public List<Stok> getAllStok() {

        return stokRepository.findAll();

    }

    // =====================
    // GET BY ID
    // =====================

    public Stok getStokById(Long id) {

        return stokRepository
                .findById(id)
                .orElse(null);

    }

    // =====================
    // ADD STOK
    // =====================

    public void addStok(Stok stok) {

        stokRepository.save(stok);

    }

    // =====================
    // UPDATE STOK
    // =====================

    public void updateStok(
            Long id,
            Stok stokBaru) {

        Stok stok =
                stokRepository
                        .findById(id)
                        .orElse(null);

        if (stok != null) {

            stok.setBarang(
                    stokBaru.getBarang());

            stok.setJumlahStok(
                    stokBaru.getJumlahStok());

            stokRepository.save(stok);

        }
    }

    // =====================
    // DELETE STOK
    // =====================

    public void deleteStok(Long id) {

        stokRepository.deleteById(id);

    }

    // =====================
    // TAMBAH STOK +1
    // =====================

    public void tambahStok(Long id) {

        Stok stok =
                stokRepository
                        .findById(id)
                        .orElse(null);

        if (stok != null) {

            stok.setJumlahStok(
                    stok.getJumlahStok() + 1);

            stokRepository.save(stok);

        }
    }

    // =====================
    // KURANG STOK -1
    // =====================

    public void kurangStok(Long id) {

        Stok stok =
                stokRepository
                        .findById(id)
                        .orElse(null);

        if (stok != null &&
            stok.getJumlahStok() > 0) {

            stok.setJumlahStok(
                    stok.getJumlahStok() - 1);

            stokRepository.save(stok);

        }
    }

    // =====================
    // TOTAL STOK
    // =====================

    public Integer getTotalStok() {

        List<Stok> stokList =
                stokRepository.findAll();

        int total = 0;

        for (Stok stok : stokList) {

            total += stok.getJumlahStok();

        }

        return total;

    }

}