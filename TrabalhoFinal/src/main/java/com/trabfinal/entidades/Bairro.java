package com.trabfinal.entidades;

import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;

public class Bairro {
    private String nome;
    private Area area;
    private double custoTransporte;

    public static Bairro novoBairroQuadrado(String nome,Ponto pSupEsq,int lado,double custoTransporte){//necessita testar
        Ponto pInfDir = new Ponto(pSupEsq.getX()+lado,pSupEsq.getY()-lado);//defini o ponto inferior
        return new Bairro(nome,new Area(pSupEsq,pInfDir),custoTransporte);
    }

    public static Bairro novoBairroRetangular(String nome,Ponto pSupEsq,int ladoH,int ladoV,double custoTransporte){//necessita testar
        Ponto pInfDir = new Ponto(pSupEsq.getX()+ladoH,pSupEsq.getY()-ladoV);
        return new Bairro(nome,new Area(pSupEsq,pInfDir),custoTransporte);
    }
    public Bairro(String nome, Area area, double custoTransporte) {//acho que falta verificar pra ver se o preco n eh negativo ou nulo
        if(custoTransporte<0.0)
        {
            throw new IllegalArgumentException("Valor do custo da viagem invalido");
        }
        else {
            this.nome = nome;
            this.area = area;
            this.custoTransporte = custoTransporte;
        }
    }

    public String getNome() {
        return nome; 
    }

    public Area getArea() {
        return area;
    }

    public double getCustoTransporte(){
        return this.custoTransporte;
    }

    public void alteraCustoTransporte(double novoValor){//testar
        if (novoValor < 0.0){
            throw new IllegalArgumentException("Valor invalido");
        }else{
            this.custoTransporte = novoValor;
        }
    }

    @Override
    public String toString() {
        return "Bairro [area=" + area + ", nome=" + nome + "]";
    }
}