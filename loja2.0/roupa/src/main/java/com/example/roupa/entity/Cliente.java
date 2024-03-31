package com.example.roupa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "tb_clientes", schema = "public")
public class Cliente extends AbstractEntity{

    @Column(name = "nome")
    @NotNull
    @NotBlank
    private String nome;

    @Column(name = "cpf")
    @NotNull
    @NotBlank
    private String cpf;

    @Column(name = "idade")
    @NotNull
    private int idade;

    @Column(name = "telefone")
    @NotNull
    @NotBlank
    private String telefone;

}
