package com.publicationmanager.publication_manager.repository;

import com.publicationmanager.publication_manager.entity.PostagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends
        JpaRepository<PostagemEntity, Integer> {

}
