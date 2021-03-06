package br.com.marinha.apiativos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.marinha.apiativos.model.militaresAtivo;

@Repository
public interface  MilitarAtivoRepository extends JpaRepository<militaresAtivo, Long>{

	@Query(value = "SELECT * FROM bieg.tb_ativo u WHERE u.cpf = ?1 order by cpf", nativeQuery = true)
			Optional<militaresAtivo> findUserByCpf(String cpf);
			
	@Query(value = "SELECT * FROM bieg.tb_ativo u WHERE u.id_pessoal = ?1 order by id_pessoal", nativeQuery = true)
	Optional<militaresAtivo> findUserByidPessoal(String id_pessoal);
	
	@Query(value = "SELECT * FROM bieg.tb_ativo u WHERE u.nome like ?1% and u.efetivo = ?2 order by nome", nativeQuery = true)
			List<militaresAtivo> findUserByNome(String nome, String efetivo);		
}
