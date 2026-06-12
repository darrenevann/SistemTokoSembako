package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Barang;
import com.example.demospringboot.entity.Stok;
import com.example.demospringboot.service.BarangService;
import com.example.demospringboot.service.StokService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StokController {

    @Autowired
    private StokService stokService;

    @Autowired
    private BarangService barangService;

    @GetMapping("/stok")
    public String stokPage(Model model) {

        model.addAttribute(
                "stokList",
                stokService.getAllStok());

        model.addAttribute(
                "barangList",
                barangService.getAllBarang());

        return "stok";
    }

    @PostMapping("/stok/add")
    public String addStok(
            @RequestParam String idBarang,
            @RequestParam Integer jumlahStok) {

        Barang barang =
                barangService.getBarangById(
                        idBarang);

        Stok stok = new Stok();

        stok.setBarang(barang);

        stok.setJumlahStok(jumlahStok);

        stokService.addStok(stok);

        return "redirect:/stok";
    }

    @PostMapping("/stok/tambah/{id}")
    public String tambahStok(
            @PathVariable Long id) {

        stokService.tambahStok(id);

        return "redirect:/stok";
    }

    @PostMapping("/stok/kurang/{id}")
    public String kurangStok(
            @PathVariable Long id) {

        stokService.kurangStok(id);

        return "redirect:/stok";
    }

}