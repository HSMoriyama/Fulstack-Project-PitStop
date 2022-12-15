package projeto.pitstop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.pitstop.model.Agendamento_Servico;
import projeto.pitstop.model.Usuario;

public interface Agendamento_ServicoRepository extends JpaRepository<Agendamento_Servico, Integer>{
	
	
	public Optional<Agendamento_Servico> findByNomeCliente(String nome);
}
