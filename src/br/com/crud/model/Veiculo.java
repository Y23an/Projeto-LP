package br.com.crud.model;
import java.util.ArrayList;

public class Veiculo {
	private String modelo;
	private String placa;
	private int capacidadeTanque;
	private Motorista motorista;
	public ArrayList<Abastecimento> abastecimentos;
	
	public Veiculo(String modelo, String placa, int capacidadeTanque) {
		this.modelo = modelo;
		this.placa = placa;
		this.capacidadeTanque = capacidadeTanque;
		this.abastecimentos = new ArrayList<>();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	@Override
	public String toString() {
		return "Veiculo [modelo=" + modelo + ", placa=" + placa + ", capacidadeTanque=" + capacidadeTanque
				+ ", motorista=" + motorista + "]";
	}
	
	public void addAbastecimento(Abastecimento abastecimento) {
		this.abastecimentos.add(abastecimento);
		System.out.println("ABASTECIMENTO ADICIONADO");
	}
	
	public void exibirAbastecimentos() {
		if (abastecimentos != null) {
			for (Abastecimento abastecimento : abastecimentos) {
				System.out.println(abastecimento.toString());
			} 
		}else {
			System.out.println("LISTA VAZIA!");
		}
	}
	
}






















