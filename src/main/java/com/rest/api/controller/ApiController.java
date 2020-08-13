package com.rest.api.controller;

import com.rest.api.model.Buku;
import com.rest.api.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/buku")
public class ApiController {
    @Autowired
    BukuRepository bukuRepository;

    @GetMapping("/")
    public List<Buku> getAll(){
        return bukuRepository.findAll();
    }

    @PostMapping("/")
    public Buku tambahbuku(@Valid @RequestBody Buku buku) {
        return bukuRepository.save(buku);
    }

    @GetMapping("/sortstatus/{statusPeminjaman}")
    public List<Buku> sortstatus(@PathVariable(value="statusPeminjaman") int statusPeminjaman){
        return bukuRepository.findByStatusPeminjaman(statusPeminjaman);
    }
}

