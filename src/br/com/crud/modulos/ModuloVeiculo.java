package br.com.crud.modulos;
import java.util.Scanner;
import java.util.ArrayList;
import br.com.crud.model.Veiculo;
import br.com.crud.model.Motorista;
import br.com.crud.model.Abastecimento;

public class ModuloVeiculo {
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Veiculo> veiculos = new ArrayList<>();
	private ModuloMotorista moduloMotorista;
	
	public ModuloVeiculo(ModuloMotorista moduloMotorista) {
		this.moduloMotorista = moduloMotorista;
	}
	
	private void menuVeiculo() {
		System.out.println ("MENU: ");
		System.out.println("1 - CADASTRAR VEICULO");
		System.out.println("2 - EXIBIR VEICULOS");
		System.out.println("3 - ASSOCIAR MOTORISTA");
		System.out.println("4 - CADASTRAR ABASTECIMENTO");
		System.out.println("5 - EXIBIR ABASTECIMENTOS POR VEICULO");
		System.out.println("6 - BUSCAR VEICULO POR PLACA");
		System.out.println("0 - SAIR");
		System.out.print("OPÇÃO: ");
	}
	
	public void iniciarVeiculo() {
		String op = null;
		do {
			this.menuVeiculo();
			op = scanner.nextLine();
			switch (op) {
			case "1":
				this.cadastrarVeiculo();
				break;
			case "2":
				this.exibirVeiculos();
				break;
			case "3":
				this.associarMotoristaVeiculo();
				break;
			case "4":
				this.cadastrarAbastecimento();
				break;
			case "5":
				this.exibirAbastecimentoPorPlaca();
				break;
			case "6":
				Veiculo veiculo = this.buscarVeiculoPorPlaca();
				veiculo.toString();
				break;
			case "0":
				System.out.println("SAINDO!");
				break;
			default:
				System.out.println("OPÇÃO INVALIDA!");
			}
		}while(!op.equals("0"));
	}
	
	private Veiculo buscarVeiculoPorPlaca() {
		System.out.print("PLACA: ");
		String placa = scanner.nextLine();
		Veiculo veiculo = this.buscarVeiculo(placa);
		if(veiculo != null) {
			System.out.println(veiculo.toString());
			return veiculo;
		}
		return null;
	}
	
	private void cadastrarVeiculo() {
		System.out.print("PLACA: ");
		String placa = scanner.nextLine();
		Veiculo veiculo = this.buscarVeiculo(placa);
		if (veiculo == null) {
			System.out.print("Modelo: ");
			String modelo = scanner.nextLine();
			System.out.print("CAPACIDADE: ");
			int capacidade = scanner.nextInt();
			scanner.nextLine();
			veiculos.add(new Veiculo(modelo, placa, capacidade));
		}else {
			System.out.println("VEICULO JA CADASTRADO!");
		}
	}
	
	private void exibirVeiculos() {
		if (veiculos != null) {
			for (Veiculo veiculo: veiculos) {
				System.out.println(veiculo.toString());
			}
		}else {
			System.out.println("LISTA VAZIA!");
		}
	}
	
	private void associarMotoristaVeiculo() {
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();
		Motorista motorista = this.moduloMotorista.buscarMotorista(cpf);
		System.out.print("PLACA: ");
		String placa = scanner.nextLine();
		Veiculo veiculo = this.buscarVeiculo(placa);
		if (motorista != null) {
			veiculo.setMotorista(motorista);
			System.out.println("MOTORISTA ASSOCIADO!");
		}
		else if(motorista == null){
			System.out.println("MOTORISTA NÃO EXISTE!");
		}
	}
	
	private void cadastrarAbastecimento() {
		System.out.print("DATA: ");
		String data = scanner.nextLine();
		System.out.print("VALOR: ");
		double valor = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("QUANTIDADE DE COMBUSTIVEL: ");
		double quantidadeCombustivel = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("TIPO(GASOLINA/ETANOL/DIESEL): ");
		String tipo = scanner.nextLine();
		System.out.print("VALOR POR LITRO: ");
		double valorLitro = scanner.nextDouble();
		scanner.nextLine();
		Abastecimento abastecimento = new Abastecimento(data, valor, quantidadeCombustivel, tipo, valorLitro);
		System.out.print("PLACA: ");
		String placa = scanner.nextLine();
		Veiculo veiculo = this.buscarVeiculo(placa);
		veiculo.addAbastecimento(abastecimento);
	}
	
	private void exibirAbastecimentoPorPlaca() {
		System.out.print("PLACA: ");
		String placa = scanner.nextLine();
		Veiculo veiculo = this.buscarVeiculo(placa);
		if (veiculo.abastecimentos != null) {
			veiculo.exibirAbastecimentos();
		}else {
			System.out.println("VEICULO SEM HISTORICO DE ABASTECIMENTOS!");
		}
	}
	
	private Veiculo buscarVeiculo(String placa) {
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
				return veiculo;
			}
		}
		return null;
	}
}















