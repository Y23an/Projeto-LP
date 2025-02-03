package br.com.crud.main;
import br.com.crud.modulos.ModuloVeiculo;
import br.com.crud.modulos.ModuloMotorista;
import java.util.Scanner;

public class Controller {
	private ModuloMotorista moduloMotorista = new ModuloMotorista();
	private ModuloVeiculo moduloVeiculo = new ModuloVeiculo(this.moduloMotorista);
	private Scanner scanner = new Scanner(System.in);
	
	public void menuController() {
		System.out.println("MENU: ");
		System.out.println("1 - MENU VEICULO");
		System.out.println("2 - MENU MOTORISTA");
		System.out.println("0 - SAIR");
		System.out.print("OPÇÃO: ");
	}
	
	public void iniciarController() {
		String op = null;
		do {
			this.menuController();
			op = scanner.nextLine();
			switch (op) {
			case "1":
				this.moduloVeiculo.iniciarVeiculo();
				break;
			case "2":
				this.moduloMotorista.iniciarMotorista();
				break;
			case "0":
				System.out.println("SAINDO!");
				break;
			default:
				System.out.println("OPÇÃO INVALIDA");
			}
		}while(!op.equals("0"));
	}
}
