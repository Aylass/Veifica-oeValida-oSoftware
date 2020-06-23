package com.trabfinal.entidades;

import com.trabfinal.entidades.geometria.Area;
import com.trabfinal.entidades.geometria.Ponto;

public class Bairro {
    private String nome;
    private Area area;
    private double custoTransporte;

    public static Bairro novoBairroQuadrado(String nome,Ponto pSupEsq,int lado,double custoTransporte){
        Ponto pInfDir = new Ponto(pSupEsq.getX()+lado,pSupEsq.getY()-lado);
        return new Bairro(nome,new Area(pSupEsq,pInfDir),custoTransporte);
    }

    public static Bairro novoBairroRetangular(String nome,Ponto pSupEsq,int ladoH,int ladoV,double custoTransporte){
        Ponto pInfDir = new Ponto(pSupEsq.getX()+ladoH,pSupEsq.getY()-ladoV);
        return new Bairro(nome,new Area(pSupEsq,pInfDir),custoTransporte);
    }
<<<<<<< HEAD
    
=======
    // Tive que remover a palavra PRIVATE desse método de baixo
>>>>>>> 380347b3179f332a7c09fc0842a4069424a7ba59
    public Bairro(String nome, Area area, double custoTransporte) {
        this.nome = nome;
        this.area = area;
        this.custoTransporte = custoTransporte;
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

    public void alteraCustoTransporte(double novoValor){
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