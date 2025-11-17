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

    public PostagemDto toDto(PostagemEntity post) {
        PostagemDto postagemDto = new PostagemDto();
        postagemDto.setId(post.getId());
        postagemDto.setAutor(post.getAutor());
        postagemDto.setTitulo(post.getTitulo());
        postagemDto.setDataPublicacao(post.getDataPublicacao());
        postagemDto.setConteudo(post.getConteudo());
        postagemDto.setPostpublicado(post.isPostPublicado());

        return postagemDto;
    }

    public PostagemEntity toEntity(PostagemDto postDto) {
        PostagemEntity postEnt = new PostagemEntity();

        postEnt.setId(postDto.getId());
        postEnt.setAutor(postDto.getAutor());
        postEnt.setTitulo(postDto.getTitulo());
        postEnt.setDataPublicacao(postDto.getDataPublicacao());
        postEnt.setConteudo(postDto.getConteudo());
        postEnt.setPostPublicado(postDto.isPostpublicado());

        return postEnt;
    }

    @Override
    public PostagemDto findById(Integer id) {
        Optional<PostagemEntity> postagemEntity = postagemRepository.findById(id);
        if (postagemEntity.isEmpty()) {
            throw new RuntimeException("Não foi possivel encontrar o post pelo seu id");
        }
        return toDto(postagemEntity.get());
    }

    @Override
    public List<PostagemDto> findAll() {
        List<PostagemEntity> listaEntitys = postagemRepository.findAll();
        List<PostagemDto> listaDtos = new ArrayList<PostagemDto>();

        for(PostagemEntity entity : listaEntitys) {
            listaDtos.add(toDto(entity));
        }
        return listaDtos;
    }

    @Override
    public PostagemDto addNew(PostagemDto postDto) {
        PostagemEntity postEntity = new PostagemEntity();
        postEntity.setAutor(postDto.getAutor());
        postEntity.setTitulo(postDto.getTitulo());
        postEntity.setDataPublicacao(postDto.getDataPublicacao());
        postEntity.setConteudo(postDto.getConteudo());
        postEntity.setPostPublicado(postDto.isPostpublicado());

        postagemRepository.save(postEntity);

        return postDto;
    }

}
