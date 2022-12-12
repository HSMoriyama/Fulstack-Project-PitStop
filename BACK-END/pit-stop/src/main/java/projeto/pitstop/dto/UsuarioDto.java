package projeto.pitstop.dto;

//CRIANDO UMA CÓPIA DE USER SÓ COM INFOS 
//REALMENTE NECESSÁRIAS
public class UsuarioDto {

	private String nome;
	private String senha;
	
	
	public UsuarioDto(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
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