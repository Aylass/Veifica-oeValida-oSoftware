package com.trabfinal.entidades.TestIntegracao;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;



public class BairroTest {

    Bairro mBairro;
    Bairro mBairroquad;

    Area area;

    @BeforeEach
    void setup(){ 
        Ponto ponfdir = new Ponto(122,22);
        Ponto ponfesq = new Ponto(100,25);
        area = new Area(ponfesq,ponfdir);
        mBairro = new Bairro("Partenon",area,10.20);
        mBairroquad.novoBairroQuadrado("Partenon", ponfesq, 4, 20.50);
    }

    @Test
    public void TestArea(){
        Area result = mBairro.getArea();
        Area expected = area;
        assertEquals(result,expected);
    }
}
