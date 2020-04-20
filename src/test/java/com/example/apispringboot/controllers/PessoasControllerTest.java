package com.example.apispringboot.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.apispringboot.models.Pessoas;
import com.example.apispringboot.repository.PessoasRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoasControllerTest {

  @Autowired
  private PessoasRepository repo;

  @Autowired
  public WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void setup() {
    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }

  @Test
  public void testListar() throws Exception {
    String url = "/api/pessoas/listar";
    this.mvc.perform(get(url)).andExpect(status().isOk());
  }

  @Test
  public void testDeletar() throws Exception {
    List<Pessoas> pessoasbefore = repo.findAll();

    String url = "/api/pessoas/{id}/deletar";
    this.mvc.perform(delete(url,1)).andExpect(status().isOk());

    List<Pessoas> pessoasafter = repo.findAll();
    assertThat(pessoasafter.size()).isEqualTo(pessoasbefore.size()-1);
  }

  @Test
  public void testDeletarFailed() throws Exception{
    String url = "/api/pessoas/1011/deletar";
    this.mvc.perform(delete(url)).andExpect(status().isBadRequest());
  }

  @Test
  public void testCriar() throws Exception {
    List<Pessoas> pessoasbefore = repo.findAll();

    String url = "/api/pessoas/adicionar";
    this.mvc.perform( MockMvcRequestBuilders
    .post(url)
    .content(asJsonString(new Pessoas(null, "Josué","Mota","Em busca de algo")))
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isCreated())
    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());

    List<Pessoas> pessoasafter = repo.findAll();
    assertThat(pessoasafter.size()).isEqualTo(pessoasbefore.size()+1);
  }

  public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
  }


  @Test
  public void testAtualizar() throws Exception {
    String url = "/api/pessoas/{id}/atualizar";

    this.mvc.perform( MockMvcRequestBuilders
    .put(url,5)
    .content(asJsonString(new Pessoas((long) 5,
            "Josué",
            "Mota",
            "Em busca de algo")))
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.first_name").value("Josué"))
    .andExpect(MockMvcResultMatchers.jsonPath("$.last_name").value("Mota"))
    .andExpect(MockMvcResultMatchers.jsonPath("$.career").value("Em busca de algo"));

  }
}