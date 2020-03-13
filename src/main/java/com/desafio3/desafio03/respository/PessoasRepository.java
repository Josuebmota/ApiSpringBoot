package com.desafio3.desafio03.respository;

import com.desafio3.desafio03.models.Pessoas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long> {

}