package projeto.pitstop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.pitstop.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
