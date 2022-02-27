
public class ContaPoupanca extends Conta {
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}
	
	
	public void imprimirExtratoCp() {
		System.out.println("===== Extrato Conta Corrente =====");
		super.imprimirInfosComuns();
		
	}
	
}
