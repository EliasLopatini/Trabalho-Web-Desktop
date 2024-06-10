package br.unipar.trabalhopdvspring.repositories;


import br.unipar.trabalhopdvspring.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    @Query
    public List<Venda> findById(long Id);

    @Query
    public List<Venda> findByObservacoes(String observacoes);

//    @Query
 //   public List<Venda> findByData(Timestamp data);

    @Query
    public List<Venda> findByTotal(double total);



}
