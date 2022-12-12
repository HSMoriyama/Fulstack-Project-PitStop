package projeto.pitstop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser")
	private Integer idUser;
	private String nome;
	private String senha;
	
	
	//CONSTRUTORES
	public Usuario(){super();}

	public Usuario(Integer idUser, String nome, String senha) {
		super();
		this.idUser = idUser;
		this.nome = nome;
		this.senha = senha;
	}

	//GETTERS&SETTERS
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
