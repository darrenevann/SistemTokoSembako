package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Transaksi;
import com.example.demospringboot.service.BarangService;
import com.example.demospringboot.service.PelangganService;
import com.example.demospringboot.service.TransaksiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private BarangService barangService;

    @Autowired
    private PelangganService pelangganService;

    // ==========================
    // HALAMAN TRANSAKSI
    // ==========================

    @GetMapping("/transaksi")
    public String transaksiPage(
            Model model) {

        model.addAttribute(
                "transaksiList",
                transaksiService.getAllTransaksi());

        model.addAttribute(
                "barangList",
                barangService.getAllBarang());

        model.addAttribute(
                "pelangganList",
                pelangganService.getAllPelanggan());

        model.addAttribute(
                "transaksiRec",
                new Transaksi());

        return "transaksi";
    }

    // ==========================
    // SIMPAN TRANSAKSI
    // ==========================

@PostMapping("/transaksi/simpan")
public String simpanTransaksi(
        @ModelAttribute Transaksi transaksi,
        Model model) {

    try {

        transaksiService.addTransaksi(
                transaksi);

        return "redirect:/transaksi";

    }
    catch (RuntimeException e) {

        model.addAttribute(
                "error",
                e.getMessage());

        model.addAttribute(
                "transaksiList",
                transaksiService.getAllTransaksi());

        model.addAttribute(
                "barangList",
                barangService.getAllBarang());

        model.addAttribute(
                "pelangganList",
                pelangganService.getAllPelanggan());

        return "transaksi";
    }
}

    // ==========================
    // HAPUS TRANSAKSI
    // ==========================

    @GetMapping("/transaksi/delete/{id}")
    public String deleteTransaksi(
            @PathVariable String id) {

        transaksiService.deleteTransaksi(
                id);

        return "redirect:/transaksi";
    }

    // ==========================
    // DETAIL TRANSAKSI
    // ==========================

    @GetMapping("/transaksi/detail/{id}")
    public String detailTransaksi(
            @PathVariable String id,
            Model model) {

        model.addAttribute(
                "transaksi",
                transaksiService.getTransaksiById(id));

        return "detailTransaksi";
    }


        @GetMapping("/transaksi/struk/{id}")
        public String cetakStruk(
                @PathVariable String id,
                Model model) {

        model.addAttribute(
                "transaksi",
                transaksiService.getTransaksiById(id));

        return "struk";
        }
}