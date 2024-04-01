package com.example.roupa.controller;

import com.example.roupa.entity.Funcionario;
import com.example.roupa.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/buscanome")
    public ResponseEntity<List<Funcionario>> findByNome(@RequestParam("nome") String n){
        try {
            List<Funcionario> lista = this.service.findByNome(n);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscaidade")
    public ResponseEntity<List<Funcionario>> findByIdade(@RequestParam("idade") int i){
        try {
            List<Funcionario> lista = this.service.findByIdade(i);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscamatricula")
    public ResponseEntity<List<Funcionario>> findByMatricula(@RequestParam("matricula") String m){
        try {
            List<Funcionario> lista = this.service.findByMatricula(m);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Funcionario> findById(@RequestParam("id") Long id)
    {
        try {
            Funcionario funcionario = this.service.findById(id);
            return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Funcionario>> listAll(){
        try {
            List<Funcionario> lista = this.service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> save(@Valid @RequestBody Funcionario funcionario)
    {
        try {
            Funcionario funcionarioSalvo = this.service.save(funcionario);
            return new ResponseEntity<>(funcionarioSalvo, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Funcionario> update(@RequestParam Long id ,@RequestBody Funcionario funcionario)
    {
        try {
            Funcionario funcionarioSalvo = this.service.update(id, funcionario);
            return new ResponseEntity<>(funcionarioSalvo, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Long id)
    {
        try {
            String mensagem = this.service.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
