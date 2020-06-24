package com.trabfinal.casosDeUso.TesteUnitario.Politicas;

import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;

public interface CalculoCustoViagem {
    void defineRoteiro(Roteiro roteiro);
    void definePassageiro(Passageiro passageiro);
	public Roteiro getRoteiro();
	public Passageiro getPassageiro();
    double calculoCustoBasico();
    double descontoPontuacao();
    double descontoPromocaoSazonal();
    double custoViagem();
}