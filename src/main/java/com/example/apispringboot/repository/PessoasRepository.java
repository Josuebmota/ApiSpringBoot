package com.example.apispringboot.repository;

import com.example.apispringboot.models.Pessoas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long> {

}