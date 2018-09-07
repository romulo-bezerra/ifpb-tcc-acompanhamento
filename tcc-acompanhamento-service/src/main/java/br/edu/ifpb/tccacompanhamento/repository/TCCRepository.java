package br.edu.ifpb.tccacompanhamento.repository;

import br.edu.ifpb.tccacompanhamento.domain.TCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TCCRepository extends JpaRepository<TCC, Integer> {

    public Optional<TCC> findById(@Param("id") Long id);

}
