package com.example.demospringboot.service;

import com.example.demospringboot.entity.Stok;
import com.example.demospringboot.repository.PengeluaranRepository;
import com.example.demospringboot.repository.StokRepository;
import com.example.demospringboot.repository.TransaksiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaporanService {

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private PengeluaranRepository pengeluaranRepository;

    @Autowired
    private StokRepository stokRepository;

    public Float getLaporanOmset() {

        Float omset =
                transaksiRepository.getOmsetKotor();

        return omset == null ? 0f : omset;
    }

    public Float getPengeluaran() {

        Float pengeluaran =
                pengeluaranRepository.totalPengeluaran();

        return pengeluaran == null ? 0f : pengeluaran;
    }

    public Float getOmsetBersih() {

        Float laba =
                transaksiRepository.getLabaBersih();

        return laba == null
                ? 0f
                : laba;

    }

    public List<Object[]> getProdukTerlaris() {

        return transaksiRepository.getProdukTerlaris();
    }

    public List<Stok> getStokMenipis() {

        return stokRepository.findByJumlahStokLessThanEqual(10);
    }
}