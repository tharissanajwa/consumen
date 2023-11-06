package com.exercise.consumen.controllers;

import com.exercise.consumen.models.ApiResponse;
import com.exercise.consumen.models.Consumen;
import com.exercise.consumen.services.ConsumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controller backend untuk restful api
@RestController
@RequestMapping("consumens")
public class ConsumenController {
    @Autowired
    private ConsumenService consumenService;

    // Metode untuk mengambil semua data konsumen dari fungsi yg telah dibuat di service
    @GetMapping
    public ResponseEntity<ApiResponse> getAllConsumen() {
        List<Consumen> consumen = consumenService.getAll();
        ApiResponse response = new ApiResponse("success", consumen);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Metode untuk mengambil data konsumen berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getConsumenById(@PathVariable("id") int id) {
        Consumen consumen = consumenService.getConsumenById(id);
        ApiResponse response = new ApiResponse("success", consumen);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Metode untuk membuat konsumen baru dari fungsi yg telah dibuat di service
    @PostMapping
    public ResponseEntity<ApiResponse> insertNewConsumen(@RequestBody Consumen consumen) {
        consumenService.addConsumen(consumen);
        ApiResponse response = new ApiResponse("success", consumen);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
