package projeto.pitstop.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projeto.pitstop.dto.Agendamento_ServicoDto;
import projeto.pitstop.dto.UsuarioDto;
import projeto.pitstop.model.Agendamento_Servico;
import projeto.pitstop.model.Usuario;
import projeto.pitstop.repository.Agendamento_ServicoRepository;
import projeto.pitstop.security.Token;


@RestController
@CrossOrigin("*")
@RequestMapping("/servico")
public class Agendamento_ServicoController {
	
	//INICIALIZAÇÃO DO LOGGER
	final Logger log = LoggerFactory.getLogger(Agendamento_ServicoController.class);
	
	@Autowired
	private Agendamento_ServicoRepository servicoRepository;

	//CRUD
	
	//METODO CREATE
	@PostMapping
	public void create(@RequestBody Agendamento_Servico servico) {
		log.info(servico.getNomeCliente());
		log.info(servico.getData());
		servicoRepository.save(servico);
	}
	
	
	//METODO READ
	@GetMapping
	public List<Agendamento_Servico> findAll(){
		return servicoRepository.findAll();
	}

	
	//METODO BUSCA POR ID**************
	@GetMapping(path = "/byidjson")
	public Optional<Agendamento_Servico> findById(@RequestBody Agendamento_Servico servico) {
		int id = servico.getIdServico();
		
		return servicoRepository.findById(id);
	}
	
	
	//METODO UPDATE
	@PutMapping
	public void update(@RequestBody Agendamento_Servico servico) {
		if(servico.getIdServico() > 0) {
			servicoRepository.save(servico);
		}
	}
	
	//METODO DELETE
	@DeleteMapping
	public void delete(@RequestBody Agendamento_Servico servico) {
		servicoRepository.delete(servico);
	}
	
	
	//METODO BUSCA POR NOME DO CLIENTE**************
	@PostMapping("/bynome")
	public Optional<Agendamento_Servico> findByNomeCliente(@RequestParam String nome){
	
		return servicoRepository.findByNomeCliente(nome);
		
	}
	
	//METODO BUSCA POR PARAMETRO ID**************
	@GetMapping(path = "/byid")
	public Optional<Agendamento_Servico> findServico(@RequestParam int id) {
		
		return servicoRepository.findById(id);
		
	}
	
	
}