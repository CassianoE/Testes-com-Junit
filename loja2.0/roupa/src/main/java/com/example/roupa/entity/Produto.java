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
@Table(name = "tb_produtos", schema = "public")
public class Produto extends AbstractEntity{

    @Column(name = "nome")
    @NotNull
    @NotBlank(message = "O NOME NAO PODE SER EM BRANCO")
    private String nome;

    @Column(name = "valor")

    @NotNull
//@NotBlank(message = "O VALOR NAO PODE SER NULO")
    private float valor;
}
