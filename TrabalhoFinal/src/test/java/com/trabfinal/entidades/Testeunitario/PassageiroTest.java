package com.trabfinal.entidades.Testeunitario;

import com.trabfinal.entidades.Passageiro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PassageiroTest {

   private static Passageiro passageiro;

    @Test
   void passageiroExistente1() {
        Throwable exception= assertThrows(IllegalArgumentException.class, ()->passageiro=Passageiro.passageiroExistente("1234567","Arthur Morgan", -50,5));
        assertEquals("pontuacao acumulada ou quantidade de avaliacoes invalida", exception.getMessage());
    }

    @Test
    void passageiroExistente2() {
        Throwable exception= assertThrows(IllegalArgumentException.class, ()->passageiro=Passageiro.passageiroExistente("1234567","Arthur Morgan", 16,-5));
        assertEquals("pontuacao acumulada ou quantidade de avaliacoes invalida", exception.getMessage());
    }

    @Test
    void getPontuacaoMedia() {
        passageiro=new Passageiro("1234567","Arthur Morgan",33,5);
        assertEquals(6,passageiro.getPontuacaoMedia());
    }

    @Test
    void infoPontuacao1() {
        passageiro=Passageiro.novoPassageiro("1234567","Arthur Morgan");
        Throwable exception= assertThrows(IllegalArgumentException.class, ()->passageiro.infoPontuacao(-5));
        assertEquals("Pontucao invalida !", exception.getMessage());
    }

    @Test
    void infoPontuacao2() {
        passageiro=Passageiro.novoPassageiro("1234567","Arthur Morgan");
        passageiro.infoPontuacao(7);
        assertEquals(15,passageiro.getPontuacaoAcumulada());
    }

    @Test
    void infoPontuacao3() {
        passageiro=Passageiro.novoPassageiro("1234567","Arthur Morgan");
        passageiro.infoPontuacao(7);
        assertEquals(2,passageiro.getQtdadeAvaliacoes());
    }


}