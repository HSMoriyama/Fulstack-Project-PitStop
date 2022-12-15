package projeto.pitstop.dto;

public class Agendamento_ServicoDto {
	
	private String nomeCliente;

	public Agendamento_ServicoDto(String nomeCliente) {
		super();
		this.nomeCliente = nomeCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
}
