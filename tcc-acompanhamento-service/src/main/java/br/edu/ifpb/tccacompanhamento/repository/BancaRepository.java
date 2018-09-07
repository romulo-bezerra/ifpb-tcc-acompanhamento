package br.edu.ifpb.tccacompanhamento.repository;

import br.edu.ifpb.tccacompanhamento.domain.Banca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BancaRepository extends JpaRepository<Banca, Integer> {

    public Optional<Banca> findById(@Param("id") Long id);

}
