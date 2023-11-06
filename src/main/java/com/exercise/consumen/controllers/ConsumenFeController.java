package com.exercise.consumen.controllers;

import com.exercise.consumen.models.Consumen;
import com.exercise.consumen.services.ConsumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// Controller front end untuk view website
@Controller
public class ConsumenFeController {

    @Autowired
    private ConsumenService consumenService;

    @RequestMapping("/welcome")
    public String welcomepage() {
        return "Welcome to Tharissa";
    }

    // Metode untuk mengambil semua data konsumen dari fungsi yg telah dibuat di service
    @GetMapping("/")
    public String getAllConsumen(Model model) {
        List<Consumen> consumen = consumenService.getAll();
        if (consumen.size() > 0) {
            model.addAttribute("consumen", consumen);
        }
        return "list-consumens";
    }

    // Metode untuk membuat konsumen baru dari fungsi yg telah dibuat di service
    @GetMapping("/add-consumen")
    public String addConsumen(Model model) {
        model.addAttribute("consumen", new Consumen());
        return "add-consumen";
    }

    // Metode untuk simpan konsumen baru dari fungsi yg telah dibuat di service
    @PostMapping("/save-consumen")
    public String saveConsumen(Consumen consumen) {
        consumenService.addConsumen(consumen);
        return "redirect:/";
    }
}
