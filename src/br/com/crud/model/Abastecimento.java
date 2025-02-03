package br.com.crud.model;

public class Abastecimento {
	private String data;
	private double valor;
	private double quantidadeCombustivel;
	private String tipo;
	private double valorLitro;
	
	public Abastecimento(String data, double valor, double quantidadeCombustivel, String tipo, double valorLitro) {
		this.data = data;
		this.valor = valor;
		this.quantidadeCombustivel = quantidadeCombustivel;
		this.tipo = tipo;
		this.valorLitro = valorLitro;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getQuantidadeCombustivel() {
		return quantidadeCombustivel;
	}

	public void setQuantidadeCombustivel(double quantidadeCombustivel) {
		this.quantidadeCombustivel = quantidadeCombustivel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValorLitro() {
		return valorLitro;
	}

	public void setValorLitro(double valorLitro) {
		this.valorLitro = valorLitro;
	}

	@Override
	public String toString() {
		return "Abastecimento [data=" + data + ", valor=" + valor + ", quantidadeCombustivel=" + quantidadeCombustivel
				+ ", tipo=" + tipo + ", valorLitro=" + valorLitro + "]";
	}
	
	
	
}
