package com.publicationmanager.publication_manager.service;

import com.publicationmanager.publication_manager.dto.PostagemDto;
import com.publicationmanager.publication_manager.entity.PostagemEntity;
import com.publicationmanager.publication_manager.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostagemServiceImpl implements PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    private PostagemDto toDto(PostagemEntity post) {
        PostagemDto dto = new PostagemDto();
        dto.setId(post.getId());
        dto.setAutor(post.getAutor());
        dto.setTitulo(post.getTitulo());
        dto.setDataPublicacao(post.getDataPublicacao());
        dto.setConteudo(post.getConteudo());
        return dto;
    }

    public PostagemEntity toEntity(PostagemDto postDto) {
        PostagemEntity postEnt = new PostagemEntity();
        postEnt.setId(postDto.getId());
        postEnt.setAutor(postDto.getAutor());
        postEnt.setTitulo(postDto.getTitulo());
        postEnt.setDataPublicacao(postDto.getDataPublicacao());
        postEnt.setConteudo(postDto.getConteudo());
        return postEnt;
    }

    @Override
    public PostagemDto findById(Integer id) {
        Optional<PostagemEntity> postagemEntity = postagemRepository.findById(id);
        if (postagemEntity.isEmpty()) {
            throw new RuntimeException("Post não encontrado: " + id);
        }
        return toDto(postagemEntity.get());
    }

    @Override
    public List<PostagemDto> findAll() {
        List<PostagemEntity> listaEntitys = postagemRepository.findAll();
        List<PostagemDto> listaDtos = new ArrayList<PostagemDto>();

        for (PostagemEntity entity : listaEntitys) {
            listaDtos.add(toDto(entity));
        }
        return listaDtos;
    }

    @Override
    public PostagemDto addNew(PostagemDto dto) {
        PostagemEntity entity = toEntity(dto);
        PostagemEntity salvo = postagemRepository.save(entity);
        return toDto(salvo);
    }


    @Override
    public PostagemDto delete(Integer id) {
       PostagemEntity entity = postagemRepository.findById(id)
               .orElseThrow(() ->  new RuntimeException("Post não encontrado: " + id));
       postagemRepository.delete(entity);
       return toDto(entity);
    }

    @Override
    public PostagemDto update(Integer id, PostagemDto dto) {
        return null;
    }

}
