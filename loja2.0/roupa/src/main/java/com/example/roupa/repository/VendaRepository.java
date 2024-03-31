package com.example.roupa.repository;

import com.example.roupa.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query("SELECT v FROM Venda v WHERE v.endereco = :endereco")
    public List<Venda> findByEndereco(@Param("endereco") String endereco);

    public List<Venda> findByClienteNome(String nome);

    public List<Venda> findByFuncionarioNome(String nome);


}
