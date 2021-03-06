package com.trabfinal.entidades;

public class Passageiro{
	private String cpf;
	private String nome;
	private int pontuacaoAcumulada;
	private int qtdadeAvaliacoes;

	public static Passageiro novoPassageiro(String cpf, String nome){
		return new Passageiro(cpf,nome,8,1);
	}

	public static Passageiro passageiroExistente(String cpf, String nome, int pontuacaoAcumulada, int qtdadeAvaliacoes){
		return new Passageiro(cpf,nome,pontuacaoAcumulada,qtdadeAvaliacoes);//fazer teste
	}
	public Passageiro(String cpf, String nome, int pontuacaoAcumulada, int qtdadeAvaliacoes) {
		if(pontuacaoAcumulada < 0 || qtdadeAvaliacoes<=0) {//não estava tratando valores invalidos
			throw new IllegalArgumentException("pontuacao acumulada ou quantidade de avaliacoes invalida");
		}
		else{
			this.cpf = cpf;
			this.nome = nome;
			this.pontuacaoAcumulada = pontuacaoAcumulada;
			this.qtdadeAvaliacoes = qtdadeAvaliacoes;
		}
	}

	public String getCPF() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public int getPontuacaoMedia() {
		return pontuacaoAcumulada / qtdadeAvaliacoes;
	}

	public void infoPontuacao(int pontuacao) {//fazer teste
		if (pontuacao > 0) {
			pontuacaoAcumulada += pontuacao;
			qtdadeAvaliacoes++;
		} else {
			throw new IllegalArgumentException("Pontucao invalida !");
		}
	}

	public int getPontuacaoAcumulada() {
		return pontuacaoAcumulada;
	}

	public int getQtdadeAvaliacoes() {
		return qtdadeAvaliacoes;
	}

	@Override
	public String toString() {
		return "Passageiro [cpf=" + cpf + ", nome=" + nome + ", pontuacaoAcumulada=" + pontuacaoAcumulada
				+ ", qtdadeAvaliacoes=" + qtdadeAvaliacoes + "]";
	}
}
