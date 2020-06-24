package com.trabfinal.entidades.TestIntegracao;

import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;
import com.trabfinal.entidades.Viagem;
import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;



public class ViagemTest {

    Passageiro passageiro;
    Roteiro roteiro;
    Bairro bairroOrigem;
    Bairro bairroDestino;
    ArrayList<Bairro> listbairro;

    Viagem viagem;


    @BeforeEach
    void setup(){
        passageiro = new Passageiro("00022224455", "Anivia",8,1);

        Ponto ponfdir = new Ponto(122,22);
        Ponto ponfesq = new Ponto(100,25);
        Area area = new Area(ponfesq,ponfdir);
        bairroDestino = new Bairro("Partenon",area,10.20);
        bairroOrigem = new Bairro("Mário Quintana",area,20.00);
        bairroOrigem.novoBairroQuadrado("Partenon", ponfesq, 4, 20.50);
        listbairro = new ArrayList<Bairro>();
        listbairro.add(bairroDestino);
        listbairro.add(bairroOrigem);
        roteiro = new Roteiro(bairroOrigem, bairroDestino, listbairro);

        LocalDateTime datahora = LocalDateTime.of(2017, 2, 13, 15, 56);
        viagem = new Viagem(4, datahora, roteiro, passageiro, 12.50);
    }

    @Test
    public void TestPassageiroCPF(){
        String result = viagem.getPassageiro().getCPF();
        String expected = "00022224455";
        assertEquals(result,expected);
    }

    @Test
    public void TestPassageiroNome(){
        String result = viagem.getPassageiro().getNome();
        String expected = "Anivia";
        assertEquals(result,expected);
    }

    @Test
    public void TestRoteiro(){
        Bairro result = viagem.getRoteiro().getBairroDestino();
        Bairro expected = roteiro.getBairroDestino();
        assertEquals(result,expected);
    }
}
