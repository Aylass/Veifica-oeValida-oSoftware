package com.trabfinal.Area.unitario;
import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AreaTesteUnitario {
    private static Ponto pontoSupEsq, pontoInfDir;

    @Test
    public static void pontoCentral1X() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(-10);
        when(pontoSupEsq.getY()).thenReturn(-20);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(-20);
        when(pontoInfDir.getY()).thenReturn(0);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(0,area.pontoCentral().getX());
    }

    @Test
    public static void pontoCentral1Y() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(-10);
        when(pontoSupEsq.getY()).thenReturn(-20);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(-20);
        when(pontoInfDir.getY()).thenReturn(0);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(0,area.pontoCentral().getY());
    }

    @Test
    public static void pontoCentral2X() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(-30);
        when(pontoSupEsq.getY()).thenReturn(-20);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(-40);
        when(pontoInfDir.getY()).thenReturn(-10);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(-20,area.pontoCentral().getX());
    }

    @Test
    public static void pontoCentral2Y() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(-30);
        when(pontoSupEsq.getY()).thenReturn(-20);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(-40);
        when(pontoInfDir.getY()).thenReturn(-10);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(-10,area.pontoCentral().getY());
    }

    @Test
    public static void pontoCentral3X() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(10);
        when(pontoSupEsq.getY()).thenReturn(5);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(3);
        when(pontoInfDir.getY()).thenReturn(14);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(17,area.pontoCentral().getX());
    }

    @Test
    public static void pontoCentral3Y() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(10);
        when(pontoSupEsq.getY()).thenReturn(5);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(3);
        when(pontoInfDir.getY()).thenReturn(14);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(14,area.pontoCentral().getY());
    }

    @Test
    public static void mensagemDeExcecao() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(10);
        when(pontoSupEsq.getY()).thenReturn(5);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(3);
        when(pontoInfDir.getY()).thenReturn(14);
        assertEquals("O retangulo deve ser definido pela diagonal principal",new Area(pontoSupEsq,pontoInfDir));
    }
}
