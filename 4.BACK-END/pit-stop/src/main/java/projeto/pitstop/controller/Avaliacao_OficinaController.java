package projeto.pitstop.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.pitstop.model.Avaliacao_Oficina;
import projeto.pitstop.repository.Avaliacao_OficinaRepository;

@RestController
@RequestMapping("/avaliacao/oficina")
public class Avaliacao_OficinaController {

	@Autowired
	private Avaliacao_OficinaRepository avaliacaoRepository;

	//CRUD
	
	//METODO CREATE
	@PostMapping
	public void create(@RequestBody Avaliacao_Oficina avaliacao) {
		avaliacaoRepository.save(avaliacao);
	}
	
	//METODO READ
	@GetMapping
	public List<Avaliacao_Oficina> findAll(){
		return avaliacaoRepository.findAll();
	}
	
	//METODO BUSCA POR ID
	@GetMapping(path = "/avaliacaobyid")
	public Optional<Avaliacao_Oficina> findById(@RequestBody Avaliacao_Oficina avaliacao) {
		int id = avaliacao.getIdAvaliacaoOficina();
		
		return avaliacaoRepository.findById(id);
	}
	
	/*************IMPLEMENTAR COM BUSCA POR ID****************/
	//METODO UPDATE
	@PutMapping
	public void update(@RequestBody Avaliacao_Oficina avaliacao) {
		if(avaliacao.getIdAvaliacaoOficina() > 0) {
			avaliacaoRepository.save(avaliacao);
		}
	}
	
	/*************IMPLEMENTAR COM BUSCA POR ID****************/
	//METODO DELETE
	@DeleteMapping
	public void delete(@RequestBody Avaliacao_Oficina avaliacao) {
		avaliacaoRepository.delete(avaliacao);
	}
	
}
