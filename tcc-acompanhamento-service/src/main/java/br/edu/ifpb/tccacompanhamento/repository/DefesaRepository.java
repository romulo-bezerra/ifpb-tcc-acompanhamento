package br.edu.ifpb.tccacompanhamento.repository;

import br.edu.ifpb.tccacompanhamento.domain.Defesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DefesaRepository extends JpaRepository<Defesa, Integer> {

    public Optional<Defesa> findById(@Param("id") Long id);

}
