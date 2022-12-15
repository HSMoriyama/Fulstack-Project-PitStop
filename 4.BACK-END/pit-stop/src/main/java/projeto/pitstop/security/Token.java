package projeto.pitstop.security;

public class Token {

	private String token;
	
	
	//CONSTRUTOR 
	public Token(String token) {
		super();
		this.token = token;
	}

	//GETTERS && SETTERS
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
	
}