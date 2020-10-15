package br.com.marinha.apiativos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.marinha.apiativos.model.profissao;

@Repository
public interface ProfissaoRepository extends JpaRepository<profissao, Long>{
	
	@Query(value = "SELECT * FROM bieg.tb_profissao u WHERE u.cpf = ?1 order by cpf", nativeQuery = true)
	Optional<profissao> findUserByCpf(String cpf);
	
	@Query(value = "SELECT * FROM bieg.tb_profissao u WHERE u.id_pessoal = ?1 order by id_pessoal", nativeQuery = true)
	Optional<profissao> findUserByidPessoal(String idpessoal);

	@Query(value = "SELECT * FROM bieg.tb_profissao u WHERE UPPER(u.nome) like ?1% and UPPER(u.profissao) like ?2% order by nome", nativeQuery = true)
	List<profissao> findUserByNome(String nome, String efetivo);		

}
