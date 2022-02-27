
public class ContaCorrente extends Conta {
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
		
	}
	
	
	public void imprimirExtratoCc() {
		System.out.println("===== Extrato Conta Corrente =====");
		super.imprimirInfosComuns();
		
	}
	

}
