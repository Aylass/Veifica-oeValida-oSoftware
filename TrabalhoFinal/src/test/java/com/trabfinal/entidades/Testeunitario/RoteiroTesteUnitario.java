package com.trabfinal.entidades.Testeunitario;

import static org.junit.jupiter.api.Assertions.*;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.Roteiro;
import com.trabfinal.entidades.geometria.Ponto;
import com.trabfinal.entidades.geometria.Reta;
import com.trabfinal.entidades.geometria.SituacaoReta;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoteiroTesteUnitario {
    private static Bairro bairroA,bairroB,bairroC,bairroOrigem,bairroDestino;
    private static Ponto pontoA,pontoB;
    private static Collection<Bairro> todosBairros;
    private static Roteiro roteiro;

    @Test
    void determinaBairrosPercorridos1() {
        pontoA=mock(Ponto.class);
        when(pontoA.getX()).thenReturn(5);
        when(pontoA.getY()).thenReturn(10);

        pontoB=mock(Ponto.class);
        when(pontoB.getX()).thenReturn(3);
        when(pontoB.getY()).thenReturn(5);

        bairroOrigem=mock(Bairro.class);
        when(bairroOrigem.getArea().pontoCentral()).thenReturn(pontoA);

        bairroDestino=mock(Bairro.class);
        when(bairroDestino.getArea().pontoCentral()).thenReturn(pontoB);


        bairroA=mock(Bairro.class);

        bairroB=mock(Bairro.class);

        bairroC=mock(Bairro.class);

        todosBairros.add(bairroA);
        todosBairros.add(bairroB);
        todosBairros.add(bairroC);

        roteiro=new Roteiro(bairroOrigem,bairroDestino,todosBairros);

        //assertEquals();
    }


}