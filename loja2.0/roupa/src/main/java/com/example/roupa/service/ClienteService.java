package com.example.roupa.service;

import com.example.roupa.entity.Cliente;
import com.example.roupa.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findByNome(String nome)
    {
        List<Cliente> lista = this.repository.findByNome(nome);
        return lista;
    }

    public List<Cliente> findByIdade(int idade)
    {
        List<Cliente> lista = this.repository.findByIdade(idade);
        return lista;
    }

    public List<Cliente> findByCpf(String cpf)
    {
        List<Cliente> lista = this.repository.findByCpf(cpf);
        return lista;
    }

    public Cliente findById(Long id)
    {
        Cliente cliente = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
        return cliente;
    }

    public List<Cliente> listAll(){

       return this.repository.findAll();

    }

    public Cliente save(Cliente cliente)
    {
        Cliente clienteSalvo = this.repository.save(cliente);
        return clienteSalvo;
    }

    public Cliente update(Long id, Cliente cliente)
    {
        if(id != cliente.getId())
        {
            throw new RuntimeException("ID não coincidem");
        }
        Cliente clienteSalvo = this.repository.save(cliente);
        return clienteSalvo;
    }

    public String delete(Long id)
    {
        Cliente cliente = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        this.repository.deleteById(id);
        return "Deletado com sucesso";
    }
}
