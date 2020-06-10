package com.trabfinal.casosDeUso.Repositorios;

import java.util.List;

import com.trabfinal.entidades.Bairro;

public interface RepositorioBairros {
    Bairro recuperaPorNome(String nomeBairro);
    List<Bairro> recuperaListaBairros();
}