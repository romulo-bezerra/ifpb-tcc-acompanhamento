package br.edu.ifpb.tccacompanhamento.repository;

import br.edu.ifpb.tccacompanhamento.domain.MaterialApoio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MaterialApoioRepository extends JpaRepository<MaterialApoio, Integer> {

    public Optional<MaterialApoio> findById(@Param("id") Long id);

}
