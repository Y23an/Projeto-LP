package br.com.crud.modulos;
import java.util.Scanner;
import java.util.ArrayList;
import br.com.crud.model.Motorista;

public class ModuloMotorista {
	private ArrayList<Motorista> motoristas = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	
	public void menuMotorista() {
		System.out.println("MENU: ");
		System.out.println("1 - CADASTRAR MOTORISTA");
		System.out.println("2 - EXIBIR MOTORISTAS");
		System.out.println("3 - PROCURAR MOTORISTA POR CPF");
		System.out.println("0 - SAIR");
		System.out.print("OPÇÃO: ");
	}
	
	public void iniciarMotorista() {
		String op = null;
		do {
			this.menuMotorista();
			op = scanner.nextLine();
			switch (op) {
			case "1":
				this.cadastrarMotorista();
				break;
			case "2":
				this.exibirMotoristas();
				break;
			case "3":
				System.out.print("cpf: ");
				String cpf = scanner.nextLine();
				this.buscarMotorista(cpf);
				break;
			case "0":
				System.out.print("SAINDO!");
				break;
			default:
				System.out.println("OPÇÃO INVALIDA!");
			}
		}while(!op.equals("0"));
	}
	
	
	private void cadastrarMotorista() {
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();
		Motorista motor = this.buscarMotorista(cpf);
		if (motor == null) {
			System.out.print("NOME: ");
			String nome = scanner.nextLine();
			motoristas.add(new Motorista(nome, cpf));
		}else {
			System.out.println("MOTORISTAS JA CADASTRADO!");
		}

	}
	
	public Motorista buscarMotorista(String cpf) {
		for (Motorista motorista: motoristas) {
			if (motorista.getCpf().equalsIgnoreCase(cpf)){
				return motorista;
			}
		}
		return null;
	}
	
	private void exibirMotoristas() {
		if (motoristas != null) {
			for (Motorista motorista : motoristas) {
				System.out.println(motorista.toString());
			}
		}else {
			System.out.println("LISTA VAZIA!");
		}
	}
	
	
}












