package com.trabfinal.entidades.Testeunitario;

import static org.junit.jupiter.api.Assertions.*;

import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;
import com.trabfinal.entidades.Viagem;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ViagemTest {

    private static Roteiro roteiro;
    private static Passageiro passageiro;
    private static Viagem viagem;
    private static LocalDateTime dataHora;

    @Test
    void construtor1()
    {
        LocalDateTime dataHora = LocalDateTime.of(2021,10,12,21,30);
        roteiro=mock(Roteiro.class);
        passageiro=mock(Passageiro.class);

        Throwable exception= assertThrows(IllegalArgumentException.class, ()->viagem=new Viagem(122,dataHora,roteiro,passageiro,-50));
        assertEquals("valor a ser cobrado é invalido", exception.getMessage());
    }

    @Test
    void dataHora()
    {
        Throwable exception= assertThrows(java.time.DateTimeException.class, ()->dataHora = LocalDateTime.of(2021,22,12,21,30));
        assertEquals("Invalid value for MonthOfYear (valid values 1 - 12): 22", exception.getMessage());
    }




}