package com.cadastro_estudante.forleven.repository;

import com.cadastro_estudante.forleven.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}
