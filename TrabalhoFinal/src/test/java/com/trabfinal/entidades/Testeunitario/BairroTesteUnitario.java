package com.trabfinal.entidades.Testeunitario;
import static org.junit.jupiter.api.Assertions.*;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.geometria.Ponto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BairroTesteUnitario {
private static Bairro bairro;
private static Ponto ponto;


    @Test
    void novoBairroQuadrado1X() {

        ponto=mock(Ponto.class);
        when(ponto.getX()).thenReturn(10);
        when(ponto.getY()).thenReturn(5);
        bairro=Bairro.novoBairroQuadrado("Chacara das Pedras",ponto,3,0.05);

        assertEquals(13,bairro.getArea().getPInfDir().getX());
    }

    @Test
    void novoBairroQuadrado2Y() {

        ponto=mock(Ponto.class);
        when(ponto.getX()).thenReturn(10);
        when(ponto.getY()).thenReturn(5);
        bairro=Bairro.novoBairroQuadrado("Chacara das Pedras",ponto,3,0.05);

        assertEquals(2,bairro.getArea().getPInfDir().getY());
    }

    @Test
    void novoBairroRetangular1X() {

        ponto=mock(Ponto.class);
        when(ponto.getX()).thenReturn(10);
        when(ponto.getY()).thenReturn(5);
        bairro=Bairro.novoBairroRetangular("Chacara das Pedras",ponto,8,3,7.15);

        assertEquals(18,bairro.getArea().getPInfDir().getX());
    }

    @Test
    void novoBairroRetangular1Y() {

        ponto=mock(Ponto.class);
        when(ponto.getX()).thenReturn(10);
        when(ponto.getY()).thenReturn(5);
        bairro=Bairro.novoBairroRetangular("Chacara das Pedras",ponto,8,3,7.15);

        assertEquals(2,bairro.getArea().getPInfDir().getY());
    }

    @Test
    void novoBairroQudrado2() {

        ponto=mock(Ponto.class);
        when(ponto.getX()).thenReturn(10);
        when(ponto.getY()).thenReturn(5);

        Throwable exception= assertThrows(IllegalArgumentException.class, ()->bairro=Bairro.novoBairroQuadrado("Chacara das Pedras",ponto,3,-0.10));
        assertEquals("Valor do custo da viagem invalido", exception.getMessage());
    }

    @Test
    void novoBairroRetangular2() {

        ponto=mock(Ponto.class);
        when(ponto.getX()).thenReturn(10);
        when(ponto.getY()).thenReturn(5);

        Throwable exception= assertThrows(IllegalArgumentException.class, ()->bairro=Bairro.novoBairroRetangular("Chacara das Pedras",ponto,8,3,-5.09));
        assertEquals("Valor do custo da viagem invalido", exception.getMessage());
    }

    @Test
    void alterarCustoTransporte1() {

        ponto=mock(Ponto.class);
        when(ponto.getX()).thenReturn(10);
        when(ponto.getY()).thenReturn(5);
        bairro=Bairro.novoBairroQuadrado("Chacara das Pedras",ponto,3,0.50);
        Throwable exception= assertThrows(IllegalArgumentException.class, ()->bairro.alteraCustoTransporte(-0.35));
        assertEquals("Valor invalido", exception.getMessage());
    }

    @Test
    void alterarCustoTransporte2() {

        ponto=mock(Ponto.class);
        when(ponto.getX()).thenReturn(10);
        when(ponto.getY()).thenReturn(5);
        bairro=Bairro.novoBairroQuadrado("Chacara das Pedras",ponto,3,0.50);
        bairro.alteraCustoTransporte(1.25);
        assertEquals(1.25,bairro.getCustoTransporte());
    }


}