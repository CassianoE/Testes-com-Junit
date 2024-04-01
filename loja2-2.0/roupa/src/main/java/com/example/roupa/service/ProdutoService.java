package com.example.roupa.service;

import com.example.roupa.entity.Produto;
import com.example.roupa.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findByNome(String nome)
    {
        List<Produto> lista = this.repository.findByNome(nome);
        return lista;
    }

    public List<Produto> findByValor(float valor)
    {
        List<Produto> lista = this.repository.findByValor(valor);
        return lista;
    }

    public Produto findById(Long id)
    {
        Produto produto = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
        return produto;
    }

    public List<Produto> listAll(){

        List<Produto> lista = this.repository.findAll();
        if(lista.isEmpty())
        {
            throw new RuntimeException("lista vazia");
        }
        return lista;
    }

    public Produto save(Produto produto)
    {
        Produto produtoSalvo = this.repository.save(produto);
        return produtoSalvo;
    }

    public Produto update(Long id, Produto produto)
    {
        if(id != produto.getId())
        {
            throw new RuntimeException("ID não coincidem");
        }
        Produto produtoSalvo = this.repository.save(produto);
        return produtoSalvo;
    }

    public String delete(Long id)
    {
        Produto produto = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        this.repository.deleteById(id);
        return "Deletado com sucesso";
    }
}
