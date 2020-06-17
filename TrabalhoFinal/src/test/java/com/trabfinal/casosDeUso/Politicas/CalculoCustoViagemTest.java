package com.trabfinal.casosDeUso.Politicas;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;
import com.trabfinal.interfaces.Persistencia.RepositorioBairrosImplMem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculoCustoViagemTest {

    @Mock
    Roteiro mRoteiro;
    @Mock
    Passageiro mPassageiro;

    CalculoCustoViagemBasico ccvb;

    RepositorioBairrosImplMem repoBairrosMem;

    ArrayList<Bairro> mockList;

    @BeforeEach
    void setup(){
        ccvb = new CalculoCustoViagemBasico();
        repoBairrosMem = new RepositorioBairrosImplMem();
        mockList = new ArrayList<Bairro>();
        MockitoAnnotations.initMocks(this);
        when(mRoteiro.bairrosPercoridos()).thenReturn(mockList);

    }

    @Test
    public void TesteUmaCidade(){
        mockList.add(repoBairrosMem.recuperaPorNome("Petropolis"));
        ccvb.definePassageiro(mPassageiro);
        ccvb.defineRoteiro(mRoteiro);
        double result = ccvb.custoViagem();
        double expected = 10;
        assertEquals(result,expected);
    }

    @Test
    public void TesteVariasCidades(){
        mockList.add(repoBairrosMem.recuperaPorNome("Petropolis"));
        mockList.add(repoBairrosMem.recuperaPorNome("Vila Nova"));
        mockList.add(repoBairrosMem.recuperaPorNome("Alegria"));
        mockList.add(repoBairrosMem.recuperaPorNome("Gavea"));
        ccvb.definePassageiro(mPassageiro);
        ccvb.defineRoteiro(mRoteiro);
        double result = ccvb.custoViagem();
        double expected = 55;
        assertEquals(result,expected);
    }

    @Test
    public void Teste0Cidade(){
        ccvb.definePassageiro(mPassageiro);
        ccvb.defineRoteiro(mRoteiro);
        double result = ccvb.custoViagem();
        double expected = 0;
        assertEquals(result,expected);
    }
}
