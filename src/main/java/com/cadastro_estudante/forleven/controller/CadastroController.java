package com.cadastro_estudante.forleven.controller;

import com.cadastro_estudante.forleven.model.Cadastro;
import com.cadastro_estudante.forleven.repository.CadastroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/cadastro"})
public class CadastroController {
    private CadastroRepository repository;

    CadastroController(CadastroRepository cadastroRepository){
        this.repository = cadastroRepository;
    }
    //métodos do CRUD aqui
    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse((ResponseEntity.notFound().build()));
    }

    @PostMapping
    public Cadastro create(@RequestBody Cadastro cadastro){
        return repository.save(cadastro);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id")long id,
                                 @RequestBody Cadastro cadastro){
        return repository.findById(id)
                .map(record -> {
                    record.setNome(cadastro.getNome());
                    record.setSobrenome(cadastro.getSobrenome());
                    record.setMatricula(cadastro.getMatricula());
                    Cadastro updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id){
        return repository.findById(id)
                .map(record ->{
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                 }).orElse(ResponseEntity.notFound().build());
    }

}
