package com.publicationmanager.publication_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "postagem")
public class PostagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O título é obrigatório")
    @Column(name = "titulo")
    private String titulo;

    @NotBlank(message = "Obrigatório informar o autor")
    @Column(name = "autor")
    private String autor;

    @NotBlank(message = "A data de publicação é obrigatória")
    @Column(name = "data")
    private LocalDate dataPublicacao;

    @NotBlank(message = "O conteúdo é obrigatório")
    @Size(min = 10, message = "O conteúdo deve ter no mínimo 10 caracteres")
    @Column(name = "conteudo")
    private String conteudo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
