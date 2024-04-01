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
@Table(name = "tb_funcionarios", schema = "public")
public class Funcionario extends AbstractEntity{

    @Column(name = "nome")
    @NotNull
    @NotBlank
    private String nome;

    @Column(name = "idade")
    @NotNull
    private int idade;

    @Column(name = "matricula")
    @NotNull
    @NotBlank
    private String matricula;
}
