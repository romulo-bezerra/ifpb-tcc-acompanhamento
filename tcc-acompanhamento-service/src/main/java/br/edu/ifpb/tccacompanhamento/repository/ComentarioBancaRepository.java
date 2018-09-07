package br.edu.ifpb.tccacompanhamento.repository;

import br.edu.ifpb.tccacompanhamento.domain.ComentarioBanca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ComentarioBancaRepository extends JpaRepository<ComentarioBanca, Integer> {

    public Optional<ComentarioBanca> findById(@Param("id") Long id);

}
