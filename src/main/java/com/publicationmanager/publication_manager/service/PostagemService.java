package com.publicationmanager.publication_manager.service;

import com.publicationmanager.publication_manager.dto.PostagemDto;

import java.util.List;

public interface PostagemService {

    PostagemDto findById(Integer id);

    List<PostagemDto> findAll();

    PostagemDto addNew(PostagemDto dto);

    PostagemDto delete(Integer id);

    PostagemDto update(Integer id, PostagemDto dto);

}
