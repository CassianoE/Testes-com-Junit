package com.example.roupa.controller;

import com.example.roupa.entity.Produto;
import com.example.roupa.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/buscanome")
    public ResponseEntity<List<Produto>> findByNome(@RequestParam("nome") String n){
        try {
            List<Produto> lista = this.service.findByNome(n);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscavalor")
    public ResponseEntity<List<Produto>> findByValor(@RequestParam("valor") float v){
        try {
            List<Produto> lista = this.service.findByValor(v);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Produto> findById(@RequestParam("id") Long id)
    {
        try {
            Produto produto = this.service.findById(id);
            return new ResponseEntity<>(produto, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produto>> listAll(){
        try {
            List<Produto> lista = this.service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto)
    {
        try {
            Produto produtoSalvo = this.service.save(produto);
            return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestParam Long id ,@RequestBody Produto produto)
    {
        try {
            Produto produtoSalvo = this.service.update(id, produto);
            return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
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
