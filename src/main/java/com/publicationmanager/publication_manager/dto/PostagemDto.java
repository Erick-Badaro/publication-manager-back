package com.publicationmanager.publication_manager.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public class PostagemDto {

    private Integer id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "O autor é obrigatório")
    private String autor;

    @NotNull(message = "A data de publicação é obrigatória")
    private LocalDate dataPublicacao;

    @NotBlank(message = "O conteúdo é obrigatório")
    @Size(min = 10, message = "O conteúdo deve ter no mínimo 10 caracteres")
    private String conteudo;

    public PostagemDto(Integer id, String titulo, String autor, LocalDate dataPublicacao, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.conteudo = conteudo;
    }

    public PostagemDto() {

    }

    @JsonIgnore // Anotação para ignorar este método no Swagger
    public boolean isPublicado() {
        return !dataPublicacao.isAfter(LocalDate.now());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


}
