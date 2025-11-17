package com.publicationmanager.publication_manager.controller;

import com.publicationmanager.publication_manager.dto.PostagemDto;
import com.publicationmanager.publication_manager.service.PostagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*")
public class PostagemController {

    @Autowired
    private PostagemService service;

    @GetMapping
    public List<PostagemDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PostagemDto findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity addNew(@Valid @RequestBody PostagemDto dto) {
        PostagemDto novaPostagem = service.addNew(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(novaPostagem.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}