package com.tddjunit.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tddjunit.teste.model.ContatoModel;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {

}
