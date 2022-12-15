package projeto.pitstop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private Integer idCliente;
	private String nome;
	private long CPF;
	private long RG;
	private long telefone;
	private String email;
	private String endereco;
	
	@JsonIgnore
	@ManyToOne//N CLIENTES PARA UMA OFICINA
	private Oficina oficina;
	
	
	//CONSTRUTORES
	public Cliente(){super();}
	
	public Cliente(Integer idCliente, String nome, long cpf, long rg, long telefone, String email, String endereco,
				   Oficina oficina) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.CPF = cpf;
		this.RG = rg;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.oficina = oficina;
	}

	//GETTERS&SETTERS
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCPF() {
		return CPF;
	}

	public void setCPF(long cpf) {
		CPF = cpf;
	}

	public long getRG() {
		return RG;
	}

	public void setRG(long rg) {
		RG = rg;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
		
}
