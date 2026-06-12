package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Pelanggan;
import com.example.demospringboot.service.PelangganService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PelangganController {

    @Autowired
    private PelangganService pelangganService;

    // ==========================
    // HALAMAN PELANGGAN
    // ==========================

    @GetMapping("/pelanggan")
    public String pelangganPage(
            Model model) {

        model.addAttribute(
                "pelangganList",
                pelangganService.getAllPelanggan());

        model.addAttribute(
                "pelangganRec",
                new Pelanggan());

        return "pelanggan";
    }

    // ==========================
    // TAMBAH PELANGGAN
    // ==========================

    @PostMapping("/pelanggan/add")
    public String addPelanggan(
            @ModelAttribute Pelanggan pelanggan) {

        pelangganService.addPelanggan(
                pelanggan);

        return "redirect:/pelanggan";
    }

    // ==========================
    // HAPUS PELANGGAN
    // ==========================

    @GetMapping("/pelanggan/delete/{id}")
    public String deletePelanggan(
            @PathVariable String id) {

        pelangganService.deletePelanggan(
                id);

        return "redirect:/pelanggan";
    }

}