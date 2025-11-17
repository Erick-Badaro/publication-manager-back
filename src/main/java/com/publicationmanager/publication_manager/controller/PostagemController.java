package com.publicationmanager.publication_manager.controller;

import com.publicationmanager.publication_manager.dto.PostagemDto;
import com.publicationmanager.publication_manager.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
