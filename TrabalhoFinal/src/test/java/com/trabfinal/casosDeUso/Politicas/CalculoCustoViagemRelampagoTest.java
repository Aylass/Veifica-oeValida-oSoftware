package com.trabfinal.casosDeUso.Politicas;

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

public class CalculoCustoViagemRelampagoTest {
    @Mock
    Passageiro mPassageiro;

    @Mock
    Roteiro mRoteiro;

    @Mock
    Bairro mBairro;

    CalculoCustoViagemRelampago ccvr;

    RepositorioBairrosImplMem repoBairrosMem;

    ArrayList<Bairro> mockList;

    @BeforeEach
    void setup(){
        ccvr = new CalculoCustoViagemRelampago();
        repoBairrosMem = new RepositorioBairrosImplMem();
        mockList = new ArrayList<Bairro>();
        MockitoAnnotations.initMocks(this);

        when(mRoteiro.bairrosPercoridos()).thenReturn(mockList);

        when(mBairro.getCustoTransporte()).thenReturn(10.0);
        when(mBairro.getArea()).thenReturn(null);
        when(mBairro.getNome()).thenReturn("Test");
    }

    @Test
    public void TesteDescontoCincoPorCento(){
        when(mPassageiro.getQtdadeAvaliacoes()).thenReturn( 60 );
        when(mPassageiro.getPontuacaoMedia()).thenReturn( 7 );
        mockList.add(mBairro);
        mockList.add(mBairro);

        double expected = 20.0 * 0.95;

        ccvr.definePassageiro(mPassageiro);
        ccvr.defineRoteiro(mRoteiro);

        double current = ccvr.custoViagem();

        assertEquals(expected, current);
    }

    @Test
    public void TesteDescontoMaisDe3Bairros(){
        when(mPassageiro.getQtdadeAvaliacoes()).thenReturn( 20 );
        when(mPassageiro.getPontuacaoMedia()).thenReturn( 5 );
        mockList.add(mBairro);
        mockList.add(mBairro);
        mockList.add(mBairro);
        mockList.add(mBairro);
        double expected = 40.0 * 0.95;

        ccvr.definePassageiro(mPassageiro);
        ccvr.defineRoteiro(mRoteiro);

        double current = ccvr.custoViagem();

        assertEquals(expected, current);
    }
    @Test
    public void TesteDescontoTodos(){
        when(mPassageiro.getQtdadeAvaliacoes()).thenReturn( 60 );
        when(mPassageiro.getPontuacaoMedia()).thenReturn( 7 );
        mockList.add(mBairro);
        mockList.add(mBairro);
        mockList.add(mBairro);
        mockList.add(mBairro);
        double expected = 40.0 * 0.90;

        ccvr.definePassageiro(mPassageiro);
        ccvr.defineRoteiro(mRoteiro);

        double current = ccvr.custoViagem();

        assertEquals(expected, current);
    }
    @Test
    public void TesteDesconto3BairrosSemDesconto(){
        when(mPassageiro.getQtdadeAvaliacoes()).thenReturn( 20 );
        when(mPassageiro.getPontuacaoMedia()).thenReturn( 5 );
        mockList.add(mBairro);
        mockList.add(mBairro);
        mockList.add(mBairro);
        double expected = 30.0;

        ccvr.definePassageiro(mPassageiro);
        ccvr.defineRoteiro(mRoteiro);

        double current = ccvr.custoViagem();

        assertEquals(expected, current);
    }
}
