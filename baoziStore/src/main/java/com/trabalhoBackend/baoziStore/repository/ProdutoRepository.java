package com.trabalhoBackend.baoziStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhoBackend.baoziStore.model.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}