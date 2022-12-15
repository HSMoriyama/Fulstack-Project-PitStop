package projeto.pitstop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Oficina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOficina")
	private Integer idOficina;
	private String razaoSocial;
	private long CNPJ;//14 nums
	private long telefone; //8nums
	private String email;
	private String endereco;
	private String status;//DISPONIVEL-LOTADA
	
	
	//CONSTRUTORES
	public Oficina() {super();}


	public Oficina(Integer idOficina, String razaoSocial, long cnpj, long telefone, String email, String endereco,
				   String status) {
		super();
		this.idOficina = idOficina;
		this.razaoSocial = razaoSocial;
		this.CNPJ = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.status = status;
	}

	//GETTERS&SETTERS
	public Integer getIdOficina() {
		return idOficina;
	}


	public void setIdOficina(Integer idOficina) {
		this.idOficina = idOficina;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public long getCNPJ() {
		return CNPJ;
	}


	public void setCNPJ(long cnpj) {
		CNPJ = cnpj;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}