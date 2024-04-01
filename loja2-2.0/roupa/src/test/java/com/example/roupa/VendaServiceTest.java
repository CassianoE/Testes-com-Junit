package com.example.roupa;

import com.example.roupa.entity.Produto;
import com.example.roupa.entity.Venda;
import com.example.roupa.service.VendaService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)

public class VendaServiceTest {

    @Test
    public void testCalcularValorTotal() {
        VendaService vendaService = new VendaService();
        List<Produto> produtos = Arrays.asList(
                new Produto("Camiseta", 50.0f),
                new Produto("Calça", 80.0f),
                new Produto("Meia", 10.0f)
        );
        double resultado = vendaService.calcularValorTotal(produtos);
        assertEquals(140.0, resultado, 0.01); // Espera-se que o valor seja 140.0
    }

    @Test
    public void testCalcularValorTotalComListaVazia() {
        // Arrange
        VendaService vendaService = new VendaService();
        Venda venda = new Venda();
        venda.setProdutos(Collections.emptyList());

        // Act
        double valorTotal = vendaService.calcularValorTotal(venda.getProdutos());

        // Assert
        assertEquals(0.0, valorTotal, 0.01);
    }

    @Test
    public void testVerificarStatusVendaCanceladaComListaProdutosNula() {
        // Arrange
        VendaService vendaService = new VendaService();
        Venda venda = new Venda();
        venda.setStatus("CANCELADO");
        venda.setProdutos(null);

        // Act
        Venda vendaVerificada = vendaService.verificarStatus(venda);

        // Assert
        assertEquals(0.0, vendaVerificada.getValor_total(), 0.001); // Usando delta para comparar valores de ponto flutuante
        assertEquals(0, vendaVerificada.getProdutos().size());


    }

    @Test
    public void testCalcularValorTotalComProdutosNaoVazios() {
        VendaService vendaService = new VendaService();
        List<Produto> produtos = Arrays.asList(
                new Produto("Camiseta", 50.0f),
                new Produto("Calça", 80.0f),
                new Produto("Meia", 10.0f)
        );
        Venda venda = new Venda();
        venda.setProdutos(produtos);

        double valorTotal = vendaService.calcularValorTotal(venda.getProdutos());

        assertEquals(140.0, valorTotal, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerificarStatus() {
        VendaService vendaService = new VendaService();
        Venda venda = new Venda();
        venda.setStatus("CANCELADO");
        venda.setProdutos(null);

        vendaService.verificarStatus(venda);
    }
    @Test
    public void testVerificarVendaCanceladaComListaProdutosNulaEValorTotalZero() {
        VendaService vendaService = new VendaService();
        Venda venda = new Venda();
        venda.setStatus("CANCELADO");
        venda.setProdutos(null);

        Venda vendaVerificada = vendaService.verificarStatus(venda);

        assertEquals(0.0, vendaVerificada.getValor_total(), 0.001);
    }




}
