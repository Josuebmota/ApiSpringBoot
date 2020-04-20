package com.example.apispringboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import com.example.apispringboot.models.Pessoas;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoasRepositoryTest {

  @Autowired
  private PessoasRepository repo;

  //Verifico se apos inicializar o valor de pessoas é 100
  //Isso garante que ele ta conseguindo consumir a api externa
  @Test
  public void TestelistarPessoas(){
    List<Pessoas> pessoas = repo.findAll();
    assertThat(pessoas.size()).isEqualTo(100);
  
  }
}