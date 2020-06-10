package com.trabfinal.casosDeUso.Repositorios;

import java.util.List;

import com.trabfinal.entidades.Passageiro;

public interface RepositorioPassageiros {
    List<Passageiro> listaPassageiros();
    Passageiro recuperaPorCPF(String cpf);
    void atualizaPassageiro(Passageiro passageiro);
}