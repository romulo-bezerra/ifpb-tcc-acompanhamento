package br.edu.ifpb.tccacompanhamento.repository;

import br.edu.ifpb.tccacompanhamento.domain.EntregaTCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EntregaTCCRepository extends JpaRepository<EntregaTCC, Integer> {

    public Optional<EntregaTCC> findById(@Param("id") Long id);

}
