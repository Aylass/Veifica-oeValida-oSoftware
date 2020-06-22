package com.trabfinal.entidades.TestIntegracao;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class AreaTest {

    Area area;

    Ponto ponfesq;
    Ponto ponfdir;

    @Test
    public void TestPonto(){
        ponfdir = new Ponto(122,22);
        ponfesq = new Ponto(100,25);
        area = new Area(ponfesq,ponfdir);
        Ponto result = area.getPSupEsq();
        Ponto expected = ponfesq;
        assertEquals(result,expected);
    }

    @Test
    public void TestPonto2(){
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ponfdir = new Ponto(122,22);
            ponfesq = new Ponto(157,25);
            area = new Area(ponfesq,ponfdir);
        });
        String expectedString = "O retangulo deve ser definido pela diagonal principal";
        String result = exception.getMessage();
        System.out.println(result);
        assertTrue(expectedString.equals(result));
        //teste deve dar erro
    }
}
