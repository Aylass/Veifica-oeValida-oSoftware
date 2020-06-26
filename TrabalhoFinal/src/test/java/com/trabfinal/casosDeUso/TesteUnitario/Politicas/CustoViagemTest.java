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

public class CustoViagemTest {

    @Mock
    Passageiro mPassageiro;

    @Mock
    Roteiro mRoteiro;

    @Mock
    CalculoCustoViagemBasico mCcvb;

    @Mock
    Bairro mBairro;

    CustoViagem cv;

    ArrayList<Bairro> mockList;

    @BeforeEach
    void setup(){
        mockList = new ArrayList<Bairro>();

        MockitoAnnotations.initMocks(this);

        cv = new CustoViagem(mCcvb);

        when(mRoteiro.bairrosPercoridos()).thenReturn(mockList);

        when(mBairro.getCustoTransporte()).thenReturn(10.0);
        when(mBairro.getArea()).thenReturn(null);
        when(mBairro.getNome()).thenReturn("Test");
    }

    @Test
    public void TesteCustoViagem(){
        when(mPassageiro.getQtdadeAvaliacoes()).thenReturn( 60 );
        when(mPassageiro.getPontuacaoMedia()).thenReturn( 7 );
        mockList.add(mBairro);
        mockList.add(mBairro);

        double expected = 20.0 * 0.95;

        double current = cv.custoViagem(mRoteiro,mPassageiro);

        assertEquals(expected, current);
    }

}
