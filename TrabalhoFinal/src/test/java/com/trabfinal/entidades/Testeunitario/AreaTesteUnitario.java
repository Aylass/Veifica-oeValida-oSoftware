package com.trabfinal.entidades.Testeunitario;
import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;
import com.trabfinal.entidades.geometria.Reta;
import com.trabfinal.entidades.geometria.SituacaoReta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AreaTesteUnitario {
    private static Ponto pontoSupEsq, pontoInfDir, pontoReta,pontoReta2;
    private static Reta reta;

    @Test
    void construtorTest1() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(10);
        when(pontoSupEsq.getY()).thenReturn(5);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(20);
        when(pontoInfDir.getY()).thenReturn(0);

        Throwable exception= assertThrows(IllegalArgumentException.class, ()->new Area(pontoSupEsq,pontoInfDir));
        assertEquals("As cordenadas dos pontos não podem ser negativas ou nulas", exception.getMessage());
    }

    @Test
    void construtorTest2() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(-20);
        when(pontoSupEsq.getY()).thenReturn(-10);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(-5);
        when(pontoInfDir.getY()).thenReturn(-20);

        Throwable exception= assertThrows(IllegalArgumentException.class, ()->new Area(pontoSupEsq,pontoInfDir));
        assertEquals("As cordenadas dos pontos não podem ser negativas ou nulas", exception.getMessage());
    }

    @Test
    void construtorTest3() {
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
     void pontoCentral1X() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(3);
        when(pontoSupEsq.getY()).thenReturn(14);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(10);
        when(pontoInfDir.getY()).thenReturn(5);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(6,area.pontoCentral().getX());
    }

    @Test
     void pontoCentral1Y() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(3);
        when(pontoSupEsq.getY()).thenReturn(14);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(10);
        when(pontoInfDir.getY()).thenReturn(5);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(9,area.pontoCentral().getY());
    }

    @Test
    void pontoCentral2X() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(5);
        when(pontoSupEsq.getY()).thenReturn(10);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(15);
        when(pontoInfDir.getY()).thenReturn(2);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(10,area.pontoCentral().getX());
    }

    @Test
    void pontoCentral2y() {
        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(5);
        when(pontoSupEsq.getY()).thenReturn(10);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(15);
        when(pontoInfDir.getY()).thenReturn(2);

        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(6,area.pontoCentral().getY());
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

    @Test
    void classifica1() {

        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(9);
        when(pontoSupEsq.getY()).thenReturn(5);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(12);
        when(pontoInfDir.getY()).thenReturn(3);

        pontoReta=mock(Ponto.class);
        when(pontoReta.getX()).thenReturn(12);
        when(pontoReta.getY()).thenReturn(5);

        pontoReta2=mock(Ponto.class);
        when(pontoReta2.getX()).thenReturn(8);
        when(pontoReta2.getY()).thenReturn(7);

        reta=mock(Reta.class);
        when(reta.getP1()).thenReturn(pontoReta);
        when(reta.getP2()).thenReturn(pontoReta2);


        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(SituacaoReta.INTERSECTA,area.classifica(reta));
    }

    @Test
    void classifica2() {

        pontoSupEsq=mock(Ponto.class);
        when(pontoSupEsq.getX()).thenReturn(9);
        when(pontoSupEsq.getY()).thenReturn(8);

        pontoInfDir=mock(Ponto.class);
        when(pontoInfDir.getX()).thenReturn(12);
        when(pontoInfDir.getY()).thenReturn(3);

        pontoReta=mock(Ponto.class);
        when(pontoReta.getX()).thenReturn(12);
        when(pontoReta.getY()).thenReturn(13);

        pontoReta2=mock(Ponto.class);
        when(pontoReta2.getX()).thenReturn(8);
        when(pontoReta2.getY()).thenReturn(14);

        reta=mock(Reta.class);
        when(reta.getP1()).thenReturn(pontoReta);
        when(reta.getP2()).thenReturn(pontoReta2);


        Area area=new Area(pontoSupEsq,pontoInfDir);
        assertEquals(SituacaoReta.INTERSECTA,area.classifica(reta));
    }


}
