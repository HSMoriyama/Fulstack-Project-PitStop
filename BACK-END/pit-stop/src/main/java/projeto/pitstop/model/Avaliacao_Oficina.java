package projeto.pitstop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Avaliacao_Oficina {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAvaliacaoOficina;
	private String nomeCliente;/**/
	private String nomeOficina;/**/
	private String atendimento;
	private String servicoRealizado;
	private String detalheOpcional;
	
	@JsonIgnore/**/
	@ManyToOne
	private Oficina oficina;

	//CONSTRUTORES
	public Avaliacao_Oficina() {super();}

	public Avaliacao_Oficina(Integer idAvaliacaoOficina, String nomeCliente, String nomeOficina, String atendimento,
							 String servicoRealizado, String detalheOpcional, Oficina oficina) {
		super();
		this.idAvaliacaoOficina = idAvaliacaoOficina;
		this.nomeCliente = nomeCliente;
		this.nomeOficina = nomeOficina;
		this.atendimento = atendimento;
		this.servicoRealizado = servicoRealizado;
		this.detalheOpcional = detalheOpcional;
		this.oficina = oficina;
	}
	
	//GETTERS&&SETTERS
	public Integer getIdAvaliacaoOficina() {
		return idAvaliacaoOficina;
	}

	public void setIdAvaliacaoOficina(Integer idAvaliacaoOficina) {
		this.idAvaliacaoOficina = idAvaliacaoOficina;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeOficina() {
		return nomeOficina;
	}

	public void setNomeOficina(String nomeOficina) {
		this.nomeOficina = nomeOficina;
	}

	public String getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(String atendimento) {
		this.atendimento = atendimento;
	}

	public String getServicoRealizado() {
		return servicoRealizado;
	}

	public void setServicoRealizado(String servicoRealizado) {
		this.servicoRealizado = servicoRealizado;
	}

	public String getDetalheOpcional() {
		return detalheOpcional;
	}

	public void setDetalheOpcional(String detalheOpcional) {
		this.detalheOpcional = detalheOpcional;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
		
}