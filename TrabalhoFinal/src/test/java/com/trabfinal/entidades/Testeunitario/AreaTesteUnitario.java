package com.trabfinal.entidades.Testeunitario;
import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AreaTesteUnitario {
    private static Ponto pontoSupEsq, pontoInfDir, pontoReta;

    @Test
    void pontoCentral1X() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(-20);
        when(pontoSupEsq.getY()).thenReturn(-10);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(0);
        when(pontoInfDir.getY()).thenReturn(-20);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(0,area.pontoCentral().getX());
    }

    @Test
    void pontoCentral1Y() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(-20);
        when(pontoSupEsq.getY()).thenReturn(-10);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(0);
        when(pontoInfDir.getY()).thenReturn(-20);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(0,area.pontoCentral().getY());
    }

    @Test
     void pontoCentral2X() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(-40);
        when(pontoSupEsq.getY()).thenReturn(-10);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(-30);
        when(pontoInfDir.getY()).thenReturn(-20);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(-30,area.pontoCentral().getX());
    }

    @Test
     void pontoCentral2Y() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(-20);
        when(pontoSupEsq.getY()).thenReturn(-30);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(-10);
        when(pontoInfDir.getY()).thenReturn(-40);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(-20,area.pontoCentral().getY());
    }

    @Test
     void pontoCentral3X() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(3);
        when(pontoSupEsq.getY()).thenReturn(14);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(10);
        when(pontoInfDir.getY()).thenReturn(5);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(10,area.pontoCentral().getX());
    }

    @Test
     void pontoCentral3Y() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(3);
        when(pontoSupEsq.getY()).thenReturn(14);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(10);
        when(pontoInfDir.getY()).thenReturn(5);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(23,area.pontoCentral().getY());
    }

    @Test
     void mensagemDeExcecao() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(10);
        when(pontoSupEsq.getY()).thenReturn(5);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(3);
        when(pontoInfDir.getY()).thenReturn(14);
        Throwable exception= assertThrows(IllegalArgumentException.class, ()->new Area(pontoSupEsq,pontoInfDir));
        assertEquals("O retangulo deve ser definido pela diagonal principal", exception.getMessage());
    }

    @Test
     void codificaPonto1() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(8);
        when(pontoSupEsq.getY()).thenReturn(7);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(10);
        when(pontoInfDir.getY()).thenReturn(5);

        pontoReta=mock(Ponto.class);
        when(pontoReta.getX()).thenReturn(12);
        when(pontoReta.getY()).thenReturn(10);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(5,area.codificaPonto(pontoReta));
    }

    @Test
    void codificaPonto2() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(8);
        when(pontoSupEsq.getY()).thenReturn(7);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(10);
        when(pontoInfDir.getY()).thenReturn(5);

        pontoReta=mock(Ponto.class);
        when(pontoReta.getX()).thenReturn(6);
        when(pontoReta.getY()).thenReturn(3);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(10,area.codificaPonto(pontoReta));
    }

    @Test
    void codificaPonto3() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(8);
        when(pontoSupEsq.getY()).thenReturn(7);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(10);
        when(pontoInfDir.getY()).thenReturn(5);

        pontoReta=mock(Ponto.class);
        when(pontoReta.getX()).thenReturn(6);
        when(pontoReta.getY()).thenReturn(9);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(9,area.codificaPonto(pontoReta));
    }

    @Test
    void codificaPonto4() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(8);
        when(pontoSupEsq.getY()).thenReturn(7);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(10);
        when(pontoInfDir.getY()).thenReturn(5);

        pontoReta=mock(Ponto.class);
        when(pontoReta.getX()).thenReturn(12);
        when(pontoReta.getY()).thenReturn(3);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(6,area.codificaPonto(pontoReta));
    }
}
