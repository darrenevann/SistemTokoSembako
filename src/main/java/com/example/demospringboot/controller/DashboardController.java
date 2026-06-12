package com.example.demospringboot.controller;

import com.example.demospringboot.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public String dashboard(
            Model model) {

        // ==========================
        // TOTAL BARANG
        // ==========================

        model.addAttribute(
                "totalBarang",
                dashboardService.getTotalBarang());

        // ==========================
        // TOTAL STOK
        // ==========================

        model.addAttribute(
                "totalStok",
                dashboardService.getTotalStok());

        // ==========================
        // TOTAL TRANSAKSI
        // ==========================

        model.addAttribute(
                "totalTransaksi",
                dashboardService.getTotalTransaksi());

        // ==========================
        // OMSET KOTOR
        // ==========================

        model.addAttribute(
                "omsetKotor",
                dashboardService.getOmsetKotor());

        // ==========================
        // OMSET BERSIH
        // ==========================

        model.addAttribute(
                "omsetBersih",
                dashboardService.getOmsetBersih());

        // ==========================
        // PRODUK TERLARIS
        // ==========================

        model.addAttribute(
                "produkTerlaris",
                dashboardService.getProdukTerlaris());

        // ==========================
        // STOK MENIPIS
        // ==========================

        model.addAttribute(
                "stokMenipis",
                dashboardService.getStokMenipis());

        // ==========================
        // GRAFIK PENJUALAN
        // ==========================

        model.addAttribute(
                "grafikPenjualan",
                dashboardService.getGrafikPenjualan());

        return "dashboard";
    }

}