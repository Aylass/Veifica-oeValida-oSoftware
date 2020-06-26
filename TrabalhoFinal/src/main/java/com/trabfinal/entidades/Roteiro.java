package com.trabfinal.entidades;

import java.util.ArrayList;
import java.util.Collection;

import com.trabfinal.entidades.geometria.Ponto;
import com.trabfinal.entidades.geometria.Reta;
import com.trabfinal.entidades.geometria.SituacaoReta;

public class Roteiro {
    private Bairro bairroOrigem;
    private Bairro bairroDestino;
    private Reta rota;
    private Collection<Bairro> bairrosPercorridos;

    private void determinaBairrosPercorridos(Reta rota,Collection<Bairro> todosBairros){//precisa ser testada
        bairrosPercorridos = new ArrayList<Bairro>();
        for(Bairro bairro:todosBairros){
            SituacaoReta sr = bairro.getArea().classifica(rota);
            if (sr != SituacaoReta.TODA_FORA){
                bairrosPercorridos.add(bairro);
            }
        }
    }

    public Roteiro(Bairro bairroOrigem, Bairro bairroDestino,Collection<Bairro> todosBairros) {
        this.bairroOrigem = bairroOrigem;
        this.bairroDestino = bairroDestino;
        Ponto pOrig = bairroOrigem.getArea().pontoCentral();
        Ponto pDest = bairroOrigem.getArea().pontoCentral();
        rota =  new Reta(pOrig,pDest);
        determinaBairrosPercorridos(rota,todosBairros);
    }

    public Reta getRota(){
        return rota;
    }
    
    public Bairro getBairroOrigem() {
        return bairroOrigem;
    }

    public Bairro getBairroDestino() {
        return bairroDestino;
    }

    public Collection<Bairro> bairrosPercoridos(){
        return bairrosPercorridos;
    }
    
    @Override
    public String toString() {
        return "Roteiro [bairroDestino=" + bairroDestino + ", bairroOrigem=" + bairroOrigem + "]";
    }
}