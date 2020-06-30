package com.trabfinal.casosDeUso.TesteUnitario.Politicas;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustoViagemTest {
    @Mock
    CalculoCustoViagemBasico ccvb;


    @Mock
    CalculoCustoViagem ccv;

    CustoViagem cv;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        when(ccvb.getPassageiro()).thenReturn(null);
        when(ccv.custoViagem()).thenReturn(10.0);
        when(ccvb.custoViagem()).thenReturn(10.0);
        when(ccvb.getRoteiro()).thenReturn(null);
    }

    @Test
    void testChamadaCustoViagem(){
        double expected = 10.0;
        Passageiro mPassageiro = ccvb.getPassageiro();
        Roteiro mRoteiro = ccvb.getRoteiro();
        cv = new CustoViagem(ccv);
        double current = cv.custoViagem(mRoteiro,mPassageiro);

        assertEquals(expected, current);

    }

}
