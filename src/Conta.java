
public class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected double limite;
	protected Cliente Cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero	= SEQUENCIAL++;
		this.Cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
			saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		
	}

	
	@Override
	public void definirLimite(double valor) {
		
			limite += valor;
		
		
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.Cliente.getNome()));
		System.out.println(String.format("Agencia: %s", this.agencia));
		System.out.println(String.format("Numero: %s", this.numero));
		System.out.println(String.format("Saldo: %s", this.saldo));
		System.out.println(String.format("Limite: %s", this.limite));
		System.out.println(String.format("Total disponivel para saque: %s", (this.saldo + this.limite)));
	}

	public void imprimirExtratoCp() {
		
		
	}
	public void imprimirExtratoCc() {
		
		
	}
	
	

}
