package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Barang;
import com.example.demospringboot.service.BarangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class BarangController {

    @Autowired
    private BarangService barangService;

    @GetMapping("/barang")
    public String barangPage(
            Model model) {

        model.addAttribute(
                "barangList",
                barangService.getAllBarang());

        model.addAttribute(
                "barangRec",
                new Barang());

        return "barang.html";
    }

    @PostMapping("/barang/add")
public String addBarang(
        @ModelAttribute Barang barang,
        @RequestParam("gambarFile")
        MultipartFile gambarFile) {

    try {

        System.out.println("MASUK CONTROLLER");

        String namaFile =
                gambarFile.getOriginalFilename();

        System.out.println("FILE = " + namaFile);

        barang.setGambar(namaFile);

        barangService.addBarang(barang);

        System.out.println("BERHASIL SIMPAN");

    }
    catch (Exception e) {

        e.printStackTrace();

    }

    return "redirect:/barang";
}

    @GetMapping("/barang/delete/{id}")
    public String deleteBarang(
            @PathVariable String id) {

        barangService.deleteBarang(
                id);

        return "redirect:/barang";
    }

}