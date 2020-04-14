package com.example.apispringboot.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.*;

import com.example.apispringboot.models.Pessoas;
import com.example.apispringboot.repository.PessoasRepository;

import lombok.RequiredArgsConstructor;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
@Api(value = "ApiRest Pessoas")
@CrossOrigin(origins = "*")
public class PessoasController {
  @Autowired
  private PessoasRepository pessoasRepository;

  PessoasController(PessoasRepository repo){
    this.pessoasRepository = repo;
  }

  @PostMapping("/adicionar")
  @ApiOperation(value = "Adiciona Pessoas")
  public ResponseEntity<Pessoas> create(@Valid @RequestBody Pessoas product) {
    return new ResponseEntity<Pessoas>(
      pessoasRepository.save(product), 
      new HttpHeaders(), 
      HttpStatus.CREATED
    );
  }

  @GetMapping("/listar")
  @ApiOperation(value = "Retornar uma lista e pessoas")
  public ResponseEntity<?> findAll() {
    List<Pessoas> pessoas = pessoasRepository.findAll();
    if (pessoas.size() == 0) {
      return ResponseEntity
        .badRequest()
        .body("Não existe pessoas cadastradas");
    }
    return new ResponseEntity<List<Pessoas>>(
      pessoas, 
      new HttpHeaders(), 
      HttpStatus.OK
    );
  }

  @PutMapping(value = "/{id}/atualizar")
  @ApiOperation(value = "Atualiza uma determinada pessoa")
  public ResponseEntity<Pessoas> update(@PathVariable("id") long id, @Valid @RequestBody Pessoas pessoa) {
    return pessoasRepository.findById(id).map(p -> {
      p.setFirst_name(pessoa.getFirst_name());
      p.setLast_name(pessoa.getLast_name());
      p.setCareer(pessoa.getCareer());
      Pessoas updated = pessoasRepository.save(p);
      return ResponseEntity.ok().body(updated);
    }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path = { "/{id}/deletar" })
  @ApiOperation(value = "Deletar uma determinada pessoa")
  public ResponseEntity<?> delete(@PathVariable long id) {
    return pessoasRepository.findById(id).map(p -> {
      pessoasRepository.deleteById(id);
      return ResponseEntity.ok().body("Success on Delete");
    }).orElse(ResponseEntity.badRequest().body("Failed on delete"));
  }
}