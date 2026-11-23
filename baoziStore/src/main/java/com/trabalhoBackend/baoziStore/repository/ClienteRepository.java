package com.trabalhoBackend.baoziStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhoBackend.baoziStore.model.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}