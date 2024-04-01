package com.example.roupa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "tb_vendas", schema = "public")
public class Venda extends AbstractEntity{

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "valor_total")
    private double valor_total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    @NotNull
    private Cliente cliente;

    @NotBlank
    private String status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "funcionario_id")
    @NotNull
    private Funcionario funcionario;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "venda_produto",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    @NotNull
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        if (produtos == null) {
            produtos = new ArrayList<>(); // Retorna uma lista vazia se a lista de produtos for nula
        }
        return produtos;
    }


}
