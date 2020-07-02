package com.trabfinal.casosDeUso.TesteDeIntegracao.Servicos;

import com.trabfinal.casosDeUso.TesteUnitario.Politicas.CalculoCustoViagemBasico;
import com.trabfinal.casosDeUso.TesteUnitario.Servicos.ServicosPassageiro;
import com.trabfinal.entidades.Bairro;
import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;
import com.trabfinal.entidades.geometria.Reta;
import com.trabfinal.interfaces.Persistencia.RepositorioBairrosImplMem;
import com.trabfinal.interfaces.Persistencia.RepositorioPassageirosImplMem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

public class ServicosPassageiroTest {
    Passageiro passageiro;
    Roteiro roteiro;
    Bairro bairroOrigem;
    Bairro bairroDestino;
    List<Bairro> listbairro;
    RepositorioBairrosImplMem repositorioBairros;
    RepositorioPassageirosImplMem repositorioPassageiros;
    ServicosPassageiro servicosPassageiroB;    
    CalculoCustoViagemBasico ccvB;

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

        servicosPassageiroB = new ServicosPassageiro(repositorioBairros,repositorioPassageiros,ccvB);
    }

    @Test
    public void testServicosPassageiroGetBairros(){
        List<String> result = servicosPassageiroB.getListaBairros();
        List<String> expected = repositorioBairros.recuperaListaBairros().stream().map(b->b.getNome()).collect(Collectors.toList());
        assertEquals(expected, result);
    }
    @Test
    public void testServicosPassageiroGetPassageirosCadastrados(){
        List<String> result = servicosPassageiroB.getPassageirosCadastrados();
        List<String> expected = repositorioPassageiros.listaPassageiros().stream().map(b->b.getNome()).collect(Collectors.toList());
        assertEquals(expected, result);
    }
    @Test
    public void testServicosPassageiroCriaRoteiroOrigem(){
        Bairro result = servicosPassageiroB.criaRoteiro(bairroOrigem.getNome(), bairroDestino.getNome()).getBairroOrigem();
        Bairro expected = roteiro.getBairroOrigem();
        assertEquals(expected, result);
    }
    @Test
    public void testServicosPassageiroCriaRoteiroDestino(){
        Bairro result = servicosPassageiroB.criaRoteiro(bairroOrigem.getNome(), bairroDestino.getNome()).getBairroDestino();
        Bairro expected = roteiro.getBairroDestino();
        assertEquals(expected, result);
    }
    
}