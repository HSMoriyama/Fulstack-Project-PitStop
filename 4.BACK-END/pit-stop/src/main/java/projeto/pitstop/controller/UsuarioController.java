package projeto.pitstop.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.pitstop.dto.UsuarioDto;
import projeto.pitstop.model.Usuario;
import projeto.pitstop.repository.UsuarioRepository;
import projeto.pitstop.security.Token;
import projeto.pitstop.service.UsuarioService;

@RestController
@CrossOrigin("*")//DESBLOQUEIA TRAFEGO DE DADOS ENTRE PORTAS
@RequestMapping("/user")
public class UsuarioController {
	
	//INICIALIZAÇÃO DO LOGGER
	final Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioRepository userRepository;

	private UsuarioService userService;
	
	//CONSTRUTOR QUE PERMITE CRIAR OUTROS OBJS PARA 
	//USAR METODOS DO UsuarioRepository, ALEM DO userService
	public UsuarioController(UsuarioService userService) {
		
		this.userService = userService;
	
	}
	
	//CRUD
	
	//METODO CREATE
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario user) {
		
		log.info("Gravando os dados...");
		log.info("O usuário {}, foi salvo com sucesso!", user.getNome());
		return ResponseEntity.status(201).body(userService.create(user));
		
	}
	
	//METODO READ
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		
		log.info("Buscando os dados...");
		return ResponseEntity.status(200).body(userService.findAll());
		
	}
	
	//METODO BUSCA POR ID
	@GetMapping(path = "/userbyid")
	public Optional<Usuario> findById(@RequestBody Usuario user) {
		
		int id = user.getIdUser();
		log.info("Buscando os dados...");
		return userRepository.findById(id);
		
	}
	
	
	//METODO UPDATE
	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario user) {
		
		log.info("Gravando os dados...");
		log.info("O usuário {}, foi salvo com sucesso!", user.getNome());
		return ResponseEntity.status(200).body(userService.update(user));
	
	}
	
	//METODO DELETE
	@DeleteMapping //? - OBJ GENERICO
	public ResponseEntity<?> delete(@RequestBody Usuario user) {
		
		userService.delete(user);
		log.info("O usuário {}, foi deletado com sucesso!", user.getNome());
		return ResponseEntity.status(204).build();
	
	}
	
	//METODO LOGIN + VALIDAÇÃO DE SENHA PARA LOGIN ByIdUser
	@PostMapping("/login")
	public ResponseEntity<Token> logar(@RequestBody UsuarioDto user){
		
		Token token = userService.gerarToken(user);
		
		//VERIFICAÇÃO
		if(token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(403).build();
		
	}
}