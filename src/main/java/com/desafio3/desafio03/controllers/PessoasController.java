package com.desafio3.desafio03.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;

import com.desafio3.desafio03.models.Pessoas;
import com.desafio3.desafio03.respository.PessoasRepository;

import lombok.RequiredArgsConstructor;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PessoasController {

  @Autowired
  private PessoasRepository pessoasRepository;

  @PostMapping("/adicionar")
  public ResponseEntity<Pessoas> create(@Valid @RequestBody Pessoas product) {
    return new ResponseEntity<Pessoas>(pessoasRepository.save(product), new HttpHeaders(), HttpStatus.CREATED);
  }

  @PutMapping(value = "/{id}/atualizar")
  public ResponseEntity<?> update(@PathVariable("id") long id, @Valid @RequestBody Pessoas pessoa) {
    return pessoasRepository.findById(id).map(p -> {
      p.setFirstName(pessoa.getFirstName());
      p.setLastName(pessoa.getLastName());
      p.setCareer(pessoa.getCareer());
      Pessoas updated = pessoasRepository.save(p);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updated);
    }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path = { "/{id}/deletar" })
  public ResponseEntity<?> delete(@PathVariable long id) {
    return pessoasRepository.findById(id).map(p -> {
      pessoasRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Success on delete");
    }).orElse(ResponseEntity.badRequest().body("Failed on delete"));
  }

  @GetMapping("/listar")
  public ResponseEntity<?> findAll() {
    List<Pessoas> pessoas = pessoasRepository.findAll();
    if (pessoas.size() == 0) {
      return ResponseEntity.badRequest().body("Pessoas is not found");
    }
    return new ResponseEntity<List<Pessoas>>(pessoas, new HttpHeaders(), HttpStatus.OK);
  }
}