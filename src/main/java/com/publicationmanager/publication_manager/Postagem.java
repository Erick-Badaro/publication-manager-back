package com.publicationmanager.publication_manager;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public class Postagem {

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "Obrigatório informar o autor")
    private String autor;

    @NotBlank(message = "A data de publicação é obrigatória")
    private LocalDate dataPublicacao;

    @NotBlank(message = "O conteúdo é obrigatório")
    @Size(min = 10, message = "O conteúdo deve ter no mínimo 10 caracteres")
    private String conteudo;

    public Postagem(String titulo, String autor, LocalDate dataPublicacao, String conteudo) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.conteudo = conteudo;
    }

    public boolean isPublicado() {
        return !dataPublicacao.isAfter(LocalDate.now());
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
