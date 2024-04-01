package com.example.roupa.service;


import com.example.roupa.entity.Produto;
import com.example.roupa.entity.Venda;
import com.example.roupa.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public List<Venda> findByCliente(String nome) {
        List<Venda> lista = this.repository.findByClienteNome(nome);
        return lista;
    }

    public List<Venda> findByFuncionario(String nome) {
        List<Venda> lista = this.repository.findByFuncionarioNome(nome);
        return lista;
    }

    public List<Venda> findByEndereco(String endereco) {
        List<Venda> lista = this.repository.findByEndereco(endereco);
        return lista;
    }

    public Venda findById(Long id) {
        Venda venda = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
        return venda;
    }

    public List<Venda> listAll() {

        List<Venda> lista = this.repository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("lista vazia");
        }
        return lista;
    }

    public String delete(Long id) {
        Venda venda = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        this.repository.deleteById(id);
        return "Deletado com sucesso";
    }

    public String save(Venda venda) {
        double valorTotal = this.calcularValorTotal(venda.getProdutos());
        venda.setValor_total(valorTotal);
        this.repository.save(venda);
        return "OBEJTO SALVO COM SUCESS";
    }

    public String update(long id, Venda venda) {
        venda.setId(id);

        double valorTotal = this.calcularValorTotal(venda.getProdutos());
        venda.setValor_total(valorTotal);

        venda = this.verificarStatus(venda);
        this.repository.save(venda);
        return "OBEJTO ATUALIZADO COM SUCESSO";
    }

    public double calcularValorTotal(List<Produto> produtos) {
        double soma = 0;
        if (produtos != null)
            for (int i = 0; i < produtos.size(); i++) {
                soma += produtos.get(i).getValor();
            }
        return soma;
    }

    public Venda verificarStatus(Venda venda) {
        if (venda.getStatus().equals("CANCELADO")) {
            venda.setValor_total(0);
            venda.setProdutos(null);

        }
        return venda;
    }


}

