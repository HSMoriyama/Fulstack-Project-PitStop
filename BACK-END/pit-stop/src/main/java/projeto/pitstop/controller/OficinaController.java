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
import projeto.pitstop.model.Oficina;
import projeto.pitstop.repository.OficinaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/oficina")
public class OficinaController {

	@Autowired
	private OficinaRepository oficinaRepository;

	//CRUD
	
	//METODO CREATE
	@PostMapping
	public void create(@RequestBody Oficina oficina) {
		oficinaRepository.save(oficina);
	}
	
	//METODO READ
	@GetMapping
	public List<Oficina> findAll(){
		return oficinaRepository.findAll();
	}
	
	//METODO BUSCA POR ID
	@GetMapping(path = "/oficinabyid")
	public Optional<Oficina> findById(@RequestBody Oficina oficina) {
		int id = oficina.getIdOficina();
		
		return oficinaRepository.findById(id);
	}
	
	/************* BUSCA POR ID PARA ClienteController ****************/
	
	public Optional<Oficina> findByIdForCliente(Integer id) {
		return oficinaRepository.findById(id);
	}
	
	/*************IMPLEMENTAR COM BUSCA POR ID****************/
	//METODO UPDATE
	@PutMapping
	public void update(@RequestBody Oficina oficina) {
		if(oficina.getIdOficina() > 0) {
			oficinaRepository.save(oficina);
		}
	}
	
	/*************IMPLEMENTAR COM BUSCA POR ID****************/
	//METODO DELETE
	@DeleteMapping
	public void delete(@RequestBody Oficina oficina) {
		oficinaRepository.delete(oficina);
	}
	
}
