package com.trabfinal.entidades.TestIntegracao;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;
import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;
import com.trabfinal.entidades.geometria.Reta;
import com.trabfinal.interfaces.Persistencia.RepositorioBairrosImplMem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class RoteiroTest {

    Reta reta;
    Roteiro roteiro;
    Passageiro passageiro;


    Bairro bairroOrigem;
    Bairro bairroDestino;

    ArrayList<Bairro> listbairro;

    private RepositorioBairrosImplMem bairros;

    @BeforeEach
    void setup(){

        Ponto ponfdir = new Ponto(122,22);
        Ponto ponfesq = new Ponto(100,25);
        Area area = new Area(ponfesq,ponfdir);

        Ponto ponfdir2 = new Ponto(122,22);
        Ponto ponfesq2 = new Ponto(100,25);
        Area area2 = new Area(ponfesq,ponfdir);

        area = new Area(ponfesq,ponfdir);
        bairroDestino = new Bairro("Partenon", area,10.20);


        bairroOrigem = new Bairro("Loumrdes", area2,5);


        listbairro = new ArrayList<Bairro>();
        listbairro.add(bairroDestino);
        listbairro.add(bairroOrigem);

        roteiro = new Roteiro(bairroOrigem, bairroDestino, listbairro);

        Ponto pOrig = bairroOrigem.getArea().pontoCentral();
        Ponto pDest = bairroOrigem.getArea().pontoCentral();
        reta =  new Reta(pOrig,pDest);

        bairros = new RepositorioBairrosImplMem();
    }

    @Test
    public void TestBairro(){
        Bairro result = roteiro.getBairroDestino();
        Bairro expected = bairroDestino;
        assertEquals(result,expected);
    }

    @Test
    public void Testlistabairros(){
        roteiro = new Roteiro(bairros.recuperaPorNome("Boa Vista"),
                bairros.recuperaPorNome("Gavea"),
                bairros.recuperaListaBairros());
        assertEquals("Gavea", roteiro.getBairroDestino().getNome());
        assertEquals("Boa Vista", roteiro.getBairroOrigem().getNome());
    }

    @Test
    public void TestReta(){
        int result = roteiro.getRota().getP1().getX();
        int expected = reta.getP1().getX();
        assertEquals(result,expected);
    }
}