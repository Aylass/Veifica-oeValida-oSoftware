package com.trabfinal.casosDeUso.TesteUnitario.Politicas;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;
import com.trabfinal.interfaces.Persistencia.RepositorioBairrosImplMem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculoCustoViagemVeraoTest {
    @Mock
    Passageiro mPassageiro;

    @Mock
    Roteiro mRoteiro;

    @Mock
    Bairro mBairro;

    CalculoCustoViagemVerao ccvv;

    ArrayList<Bairro> mockList;

    @BeforeEach
    void setup(){
        ccvv = new CalculoCustoViagemVerao();
        mockList = new ArrayList<Bairro>();
        MockitoAnnotations.initMocks(this);

        when(mRoteiro.bairrosPercoridos()).thenReturn(mockList);

        when(mBairro.getCustoTransporte()).thenReturn(10.0);
        when(mBairro.getArea()).thenReturn(null);
        when(mBairro.getNome()).thenReturn("Test");
    }

    @Test
    public void TesteDescontoNovePorCento(){
        when(mPassageiro.getQtdadeAvaliacoes()).thenReturn( 60 );
        when(mPassageiro.getPontuacaoMedia()).thenReturn( 10 );
        mockList.add(mBairro);
        mockList.add(mBairro);

        double expected = 20.0 * 0.91;

        ccvv.definePassageiro(mPassageiro);
        ccvv.defineRoteiro(mRoteiro);

        double current = ccvv.custoViagem();
        //BUG FOUND, calculo do desconto estava sendo 90%, e não 9%
        assertEquals(expected, current);
    }

    @Test
    public void TesteDescontoMaisDe2Bairros(){
        when(mPassageiro.getQtdadeAvaliacoes()).thenReturn( 20 );
        when(mPassageiro.getPontuacaoMedia()).thenReturn( 5 );
        mockList.add(mBairro);
        mockList.add(mBairro);
        mockList.add(mBairro);
        mockList.add(mBairro);
        double expected = 40.0 * 0.90;

        ccvv.definePassageiro(mPassageiro);
        ccvv.defineRoteiro(mRoteiro);

        double current = ccvv.custoViagem();
        assertEquals(expected, current);
    }
    @Test
    public void TesteDescontoTodos(){
        when(mPassageiro.getQtdadeAvaliacoes()).thenReturn( 60 );
        when(mPassageiro.getPontuacaoMedia()).thenReturn( 10 );
        mockList.add(mBairro);
        mockList.add(mBairro);
        mockList.add(mBairro);
        mockList.add(mBairro);
        double expected = 40.0 * 0.81;

        ccvv.definePassageiro(mPassageiro);
        ccvv.defineRoteiro(mRoteiro);

        double current = ccvv.custoViagem();

        assertEquals(expected, current, 0.0001);
    }
    @Test
    public void TesteSemDesconto(){
        when(mPassageiro.getQtdadeAvaliacoes()).thenReturn( 20 );
        when(mPassageiro.getPontuacaoMedia()).thenReturn( 5 );
        mockList.add(mBairro);
        mockList.add(mBairro);
        double expected = 20.0;

        ccvv.definePassageiro(mPassageiro);
        ccvv.defineRoteiro(mRoteiro);

        double current = ccvv.custoViagem();

        assertEquals(expected, current);
    }
}
