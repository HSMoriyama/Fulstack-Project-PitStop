package projeto.pitstop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agendamento_Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idServico")
	private Integer idServico;
	private String nomeCliente;/**/
	private String telefoneCliente;/**/
	private String nomeOficina;/**/
	private String data;
	private String horario;
	private String descricaoServico;
	
	@JsonIgnore/**/
	@ManyToOne//N SERVICOS AGENDADOS POR 1 CLIENTE
	private Cliente cliente;
	
	@JsonIgnore/**/
	@ManyToOne//N SERVICOS AGENDADOS PARA 1 OFICINA
	private Oficina oficina;

	
	//CONSTRUTORES
	public Agendamento_Servico(){super();}

	public Agendamento_Servico(Integer idServico, String nomeCliente, String telefoneCliente, String nomeOficina, String data, String horario,
							   String descricaoServico, Cliente cliente, Oficina oficina) {
		super();
		this.idServico = idServico;
		this.nomeCliente = nomeCliente;
		this.telefoneCliente = telefoneCliente;
		this.nomeOficina = nomeOficina;
		this.data = data;
		this.horario = horario;
		this.descricaoServico = descricaoServico;
		this.cliente = cliente;
		this.oficina = oficina;
	}

	//GETTERS&SETTERS
	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	
	public String getNomeOficina() {
		return nomeOficina;
	}

	public void setNomeOficina(String nomeOficina) {
		this.nomeOficina = nomeOficina;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	
}