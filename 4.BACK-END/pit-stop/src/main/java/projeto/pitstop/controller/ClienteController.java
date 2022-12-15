package projeto.pitstop.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.pitstop.model.Cliente;
import projeto.pitstop.repository.ClienteRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	//CRUD
	
	//METODO CREATE
	@PostMapping
	public void create(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	//METODO READ
	@GetMapping
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	//METODO BUSCA POR ID
	@GetMapping(path = "/clientebyid")
	public Optional<Cliente> findById(@RequestBody Cliente cliente) {
		int id = cliente.getIdCliente();
		
		return clienteRepository.findById(id);
	}
	
	/*************IMPLEMENTAR COM BUSCA POR ID****************/
	//METODO UPDATE
	@PutMapping
	public void update(@RequestBody Cliente cliente) {
		if(cliente.getIdCliente() > 0) {
			clienteRepository.save(cliente);
		}
	}
	
	/*************IMPLEMENTAR COM BUSCA POR ID****************/
	//METODO DELETE
	@DeleteMapping
	public void delete(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
}
