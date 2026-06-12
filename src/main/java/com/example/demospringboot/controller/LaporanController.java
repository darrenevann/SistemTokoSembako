package com.example.demospringboot.controller;

import com.example.demospringboot.service.LaporanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/laporan")
public class LaporanController {

    @Autowired
    private LaporanService laporanService;

    @GetMapping("/keuangan")
    public String laporanKeuangan(
            Model model) {

        model.addAttribute(
                "omset",
                laporanService.getLaporanOmset());

        model.addAttribute(
                "pengeluaran",
                laporanService.getPengeluaran());

        model.addAttribute(
                "omsetBersih",
                laporanService.getOmsetBersih());

        model.addAttribute(
                "produkTerlaris",
                laporanService.getProdukTerlaris());

        model.addAttribute(
                "stokMenipis",
                laporanService.getStokMenipis());

        return "laporanKeuangan";
    }
}