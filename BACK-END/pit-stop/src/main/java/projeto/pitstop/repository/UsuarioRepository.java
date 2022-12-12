package projeto.pitstop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.pitstop.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	public Usuario findByNome(String nome);

	//METODO DE BUSCA POR NOME
	//@Query(value = "select user from usuario user where user.nome like %?%")
	//Usuario findByName(String name);
	
}