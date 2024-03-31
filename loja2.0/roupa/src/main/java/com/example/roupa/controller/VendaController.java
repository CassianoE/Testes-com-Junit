package com.example.roupa.controller;

import com.example.roupa.entity.Venda;
import com.example.roupa.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/venda")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping("/buscacliente")
    public ResponseEntity<List<Venda>> findByCliente(@RequestParam("cliente") String n){
        try {
            List<Venda> lista = this.service.findByCliente(n);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscafuncionario")
    public ResponseEntity<List<Venda>> findByFuncionario(@RequestParam("funcionario") String n){
        try {
            List<Venda> lista = this.service.findByFuncionario(n);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscaendereco")
    public ResponseEntity<List<Venda>> findByMatricula(@RequestParam("endereco") String ed){
        try {
            List<Venda> lista = this.service.findByEndereco(ed);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Venda> findById(@RequestParam("id") Long id)
    {
        try {
            Venda venda = this.service.findById(id);
            return new ResponseEntity<>(venda, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Venda>> listAll(){
        try {
            List<Venda> lista = this.service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Venda venda)
    {
        try {
            String vendaSalvo = this.service.save(venda);
            return new ResponseEntity<>(vendaSalvo, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam Long id ,@RequestBody Venda venda)
    {
        try {
            String vendaSalvo = this.service.update(id, venda);
            return new ResponseEntity<>(vendaSalvo, HttpStatus.CREATED);
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
