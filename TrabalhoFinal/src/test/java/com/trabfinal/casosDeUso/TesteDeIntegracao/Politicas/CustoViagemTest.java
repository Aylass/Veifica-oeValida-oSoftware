package com.trabfinal.casosDeUso.TesteDeIntegracao.Politicas;

import com.trabfinal.casosDeUso.TesteUnitario.Politicas.CalculoCustoViagem;
import com.trabfinal.casosDeUso.TesteUnitario.Politicas.CalculoCustoViagemBasico;
import com.trabfinal.casosDeUso.TesteUnitario.Politicas.CalculoCustoViagemRelampago;
import com.trabfinal.casosDeUso.TesteUnitario.Politicas.CalculoCustoViagemVerao;
import com.trabfinal.casosDeUso.TesteUnitario.Politicas.CustoViagem;
import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;
import com.trabfinal.interfaces.Persistencia.RepositorioBairrosImplMem;
import com.trabfinal.interfaces.Persistencia.RepositorioPassageirosImplMem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class CustoViagemTest {

    Passageiro passageiro;
    Roteiro roteiro;
    Bairro bairroOrigem;
    Bairro bairroDestino;
    List<Bairro> listbairro;
    RepositorioBairrosImplMem repositorioBairros;
    RepositorioPassageirosImplMem repositorioPassageiros;
    CustoViagem custoV;
    CustoViagem custoB;
    CustoViagem custoR;

    CalculoCustoViagem ccvV;
    CalculoCustoViagem ccvB;
    CalculoCustoViagem ccvR;

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

        ccvR = new CalculoCustoViagemRelampago();
        ccvR.definePassageiro(passageiro);
        ccvR.defineRoteiro(roteiro);

        ccvV = new CalculoCustoViagemVerao();
        ccvV.definePassageiro(passageiro);
        ccvV.defineRoteiro(roteiro);

        custoB = new CustoViagem(ccvB);
        custoR = new CustoViagem(ccvR);
        custoV = new CustoViagem(ccvV);
    }

    @Test
    public void testCustoViagemBasico(){
       double result = custoB.custoViagem(roteiro, passageiro);
       double expected = 56;
       System.out.println(result);
       assertEquals(expected,result);
    }
    @Test
    public void testCustoViagemVerao(){
        double result = custoV.custoViagem(roteiro, passageiro);
        double expected = 50.4;
        System.out.println(result);
        assertEquals(expected,result);
     }
     @Test
    public void testCustoViagemRelampago(){
        double result = custoR.custoViagem(roteiro, passageiro);
        double expected = 53.2;
        System.out.println(result);
        assertEquals(expected,result);
     }
}