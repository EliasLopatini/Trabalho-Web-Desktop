package br.unipar.trabalhopdvspring.repositories;

import br.unipar.trabalhopdvspring.domain.ItemVenda;
import br.unipar.trabalhopdvspring.domain.Tabela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TabelaRepository extends JpaRepository<Tabela, Long> {

    @Query
    public List<Tabela> findById(long Id);

    }
