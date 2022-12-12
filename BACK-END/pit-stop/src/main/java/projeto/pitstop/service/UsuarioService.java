package projeto.pitstop.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import projeto.pitstop.dto.UsuarioDto;
import projeto.pitstop.model.Usuario;
import projeto.pitstop.repository.UsuarioRepository;
import projeto.pitstop.security.Token;
import projeto.pitstop.security.TokenUtil;

@Service
public class UsuarioService {

	private UsuarioRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	
	//CONSTRUTOR QUE PERMITE CRIAR OUTROS OBJS PARA 
	//USAR METODOS DO UsuarioRepository, ALEM DO userRepository
	public UsuarioService(UsuarioRepository userRepository) {
		
		this.userRepository = userRepository;
		//REALIZA A CRIPTOGRAFIA DA SENHA
		this.passwordEncoder = new BCryptPasswordEncoder();
		
	}
	
	//CRUD
	
	//METODO CREATE
	public Usuario create(Usuario user) {
		
		//INTERCEPTAÇÃO PARA CRIPTOGRAFAR SENHA INSERIDA PELO USER
		String encoder= this.passwordEncoder.encode(user.getSenha());
		user.setSenha(encoder);
		Usuario usuarioNovo = userRepository.save(user);	
		return usuarioNovo;
		
	}
	
	//METODO READ
	@GetMapping
	public List<Usuario> findAll(){
		
		List<Usuario> lista = userRepository.findAll();
		return lista;
		
	}
	
	//METODO UPDATE
	public Usuario update(Usuario user) {
		
		//INTERCEPTAÇÃO PARA CRIPTOGRAFAR SENHA INSERIDA PELO USER
		String encoder= this.passwordEncoder.encode(user.getSenha());
		user.setSenha(encoder);
		Usuario usuarioNovo = userRepository.save(user);	
		return usuarioNovo;
		
	}
	
	//METODO DELETE
	@DeleteMapping //? - OBJ GENERICO
	public boolean delete(Usuario user) {
		
		userRepository.delete(user);
		return true;
	
	}
	
	//METODO VALIDAÇÃO DE SENHA PARA LOGIN ById
	public Boolean validarSenha(Usuario user) {
		
		String senha = userRepository.getById(user.getIdUser()).getSenha();
		Boolean valid = passwordEncoder.matches(user.getSenha(), senha);
		return valid;
	
	}

	//METODO DE CRIAÇÃO DO TOKEN
	public Token gerarToken(UsuarioDto usuario) {
		
		Usuario user = userRepository.findByNome(usuario.getNome());
		
		/*----VERIFICACAO DE SENHA----*/
		if(user != null) {
			//VERIFICANDO COMPATIBILIDADE ENTRE SENHAS
			Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
			
			//CASO SENHAS BATEREM
			if(valid) {
				//GERA UM NOVO TOKEN PARA ESTE USER
				return new Token(TokenUtil.createToken(user));
			}
		}
		
		return null;
		
	}
	
}