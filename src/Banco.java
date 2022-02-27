import java.util.List;

public class Banco {
	
	private String nomeBanco = "Javabank";
	private List<Conta> contas;
	private List<Cliente> clientes;
	
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	
	

}
