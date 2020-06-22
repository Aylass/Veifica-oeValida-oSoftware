package com.trabfinal.entidades.TestIntegracao;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;



public class AreaTest {

    Area area;

    Ponto ponfesq;
    Ponto ponfdir;

    @BeforeEach
    void setup(){ 
        area = new Area(ponfesq,ponfdir);
    }

    @Test
    public void TestPonto(){
        ponfdir = new Ponto(122,22);
        ponfesq = new Ponto(100,25);
        Ponto result = area.getPSupEsq();
        Ponto expected = ponfesq;
        assertEquals(result,expected);
    }

    @Test
    public void TestPonto2(){
        ponfdir = new Ponto(122,22);
        ponfesq = new Ponto(157,25);
        Ponto result = area.getPSupEsq();
        Ponto expected = ponfesq;
        assertEquals(result,expected);
    }
}
