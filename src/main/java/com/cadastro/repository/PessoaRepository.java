package com.cadastro.repository;

import com.cadastro.model.PessoaModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

}
