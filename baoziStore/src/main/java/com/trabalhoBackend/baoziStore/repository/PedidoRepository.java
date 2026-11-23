package com.trabalhoBackend.baoziStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhoBackend.baoziStore.model.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

}