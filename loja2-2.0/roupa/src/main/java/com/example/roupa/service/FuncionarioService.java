package com.example.roupa.service;


import com.example.roupa.entity.Funcionario;
import com.example.roupa.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> findByNome(String nome)
    {
        List<Funcionario> lista = this.repository.findByNome(nome);
        return lista;
    }

    public List<Funcionario> findByIdade(int idade)
    {
        List<Funcionario> lista = this.repository.findByIdade(idade);
        return lista;
    }

    public List<Funcionario> findByMatricula(String matricula)
    {
        List<Funcionario> lista = this.repository.findByMatricula(matricula);
        return lista;
    }

    public Funcionario findById(Long id)
    {
        Funcionario funcionario = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));
        return funcionario;
    }

    public List<Funcionario> listAll(){

        List<Funcionario> lista = this.repository.findAll();
        if(lista.isEmpty())
        {
            throw new RuntimeException("lista vazia");
        }
        return lista;
    }

    public Funcionario save(Funcionario funcionario)
    {
        Funcionario funcionarioSalvo = this.repository.save(funcionario);
        return funcionarioSalvo;
    }

    public Funcionario update(Long id, Funcionario funcionario)
    {
        if(id != funcionario.getId())
        {
            throw new RuntimeException("ID não coincidem");
        }
        Funcionario funcionarioSalvo = this.repository.save(funcionario);
        return funcionarioSalvo;
    }

    public String delete(Long id)
    {
        Funcionario funcionario = this.repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado"));
        this.repository.deleteById(id);
        return "Deletado com sucesso";
    }
}
