
public class Cliente {
	
	private int idCliente = 1;
	private String nome;
	private double renda;
	
	public Cliente (String nome, double renda) {
		this.nome = nome;
		this.renda = renda;
		this.idCliente = idCliente++;
		
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	
	

}
