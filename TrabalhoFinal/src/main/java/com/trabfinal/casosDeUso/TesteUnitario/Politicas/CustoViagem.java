package com.trabfinal.casosDeUso.TesteUnitario.Politicas;

import com.trabfinal.entidades.Passageiro;
import com.trabfinal.entidades.Roteiro;

public class CustoViagem {

    private CalculoCustoViagem ccv;
    
    public CustoViagem(CalculoCustoViagem ccv){
        this.ccv = ccv;
    }            

    public double custoViagem(Roteiro roteiro,Passageiro passageiro){
        ccv.defineRoteiro(roteiro);
        ccv.definePassageiro(passageiro);
        return ccv.custoViagem();
    }
}