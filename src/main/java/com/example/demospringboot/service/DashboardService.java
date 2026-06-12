package com.example.demospringboot.service;

import com.example.demospringboot.entity.Stok;

import com.example.demospringboot.repository.BarangRepository;
import com.example.demospringboot.repository.DetailTransaksiRepository;
import com.example.demospringboot.repository.PengeluaranRepository;
import com.example.demospringboot.repository.StokRepository;
import com.example.demospringboot.repository.TransaksiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private StokRepository stokRepository;

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private PengeluaranRepository pengeluaranRepository;

    @Autowired
    private DetailTransaksiRepository detailTransaksiRepository;

    // ==========================
    // TOTAL BARANG
    // ==========================

    public Long getTotalBarang() {

        return barangRepository.count();

    }

    // ==========================
    // TOTAL STOK
    // ==========================

    public Long getTotalStok() {

        return stokRepository.count();

    }

    // ==========================
    // TOTAL TRANSAKSI
    // ==========================

    public Long getTotalTransaksi() {

        return transaksiRepository.count();

    }

    // ==========================
    // OMSET KOTOR
    // ==========================

    public Float getOmsetKotor() {

        Float omset =
                transaksiRepository.getOmsetKotor();

        return omset == null
                ? 0f
                : omset;

    }

    // ==========================
    // TOTAL PENGELUARAN
    // ==========================

    public Float getTotalPengeluaran() {

        Float pengeluaran =
                pengeluaranRepository.totalPengeluaran();

        return pengeluaran == null
                ? 0f
                : pengeluaran;

    }

    // ==========================
    // OMSET BERSIH
    // ==========================

        public Float getOmsetBersih() {

            Float laba =
                    transaksiRepository.getLabaBersih();

            return laba == null
                    ? 0f
                    : laba;

        }
    // ==========================
    // PRODUK TERLARIS
    // ==========================

    public List<Object[]> getProdukTerlaris() {

        return transaksiRepository
                .getProdukTerlaris();

    }

    // ==========================
    // STOK MENIPIS
    // ==========================

    public List<Stok> getStokMenipis() {

        return stokRepository
                .findByJumlahStokLessThanEqual(10);

    }

    // ==========================
    // GRAFIK PENJUALAN
    // ==========================

    public List<Object[]> getGrafikPenjualan() {

        return transaksiRepository
                .getGrafikPenjualan();

    }

}