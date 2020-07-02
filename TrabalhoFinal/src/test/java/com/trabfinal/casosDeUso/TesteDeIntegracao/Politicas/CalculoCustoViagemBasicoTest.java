package com.trabfinal.casosDeUso.TesteDeIntegracao.Politicas;

import com.trabfinal.casosDeUso.TesteUnitario.Politicas.CalculoCustoViagem;
import com.trabfinal.casosDeUso.TesteUnitario.Politicas.CalculoCustoViagemBasico;
import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;
import com.trabfinal.interfaces.Persistencia.RepositorioBairrosImplMem;
import com.trabfinal.interfaces.Persistencia.RepositorioPassageirosImplMem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoCustoViagemBasicoTest {
    Passageiro passageiro;
    Roteiro roteiro;
    Bairro bairroOrigem;
    Bairro bairroDestino;
    List<Bairro> listbairro;
    RepositorioBairrosImplMem repositorioBairros;
    RepositorioPassageirosImplMem repositorioPassageiros;

    
    CalculoCustoViagem ccvB;

    @BeforeEach
    void setup(){ 
        repositorioBairros = new  RepositorioBairrosImplMem();
        bairroOrigem = repositorioBairros.recuperaPorNome("Petropolis");
        bairroDestino = repositorioBairros.recuperaPorNome("Boa Vista");
        listbairro = repositorioBairros.recuperaListaBairros();
        roteiro = new Roteiro(bairroOrigem, bairroDestino, listbairro);

        repositorioPassageiros = new RepositorioPassageirosImplMem();
        passageiro = repositorioPassageiros.recuperaPorCPF("123456789");
       

        ccvB = new CalculoCustoViagemBasico();
        ccvB.definePassageiro(passageiro);
        ccvB.defineRoteiro(roteiro);
    }

    @Test
    public void testCCVBgetSetPassageiro(){
        ccvB.definePassageiro(passageiro);
        Passageiro expected = passageiro;
        Passageiro result = ccvB.getPassageiro();
        assertEquals(expected, result);
    }

    @Test
    public void testCCVBgetSetRoteiro(){
        ccvB.defineRoteiro(roteiro);
        Roteiro expected = roteiro;
        Roteiro result = ccvB.getRoteiro();
        assertEquals(expected, result);
    }

    @Test
    public void testCCVBcustoViagem(){
        double expected = 56;
        double result = ccvB.custoViagem();
        assertEquals(expected, result);
    }
}