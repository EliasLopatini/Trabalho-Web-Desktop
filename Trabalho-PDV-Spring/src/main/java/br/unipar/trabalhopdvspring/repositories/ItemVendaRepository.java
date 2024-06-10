package br.unipar.trabalhopdvspring.repositories;

import br.unipar.trabalhopdvspring.domain.ItemVenda;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

    @Repository
    public interface ItemVendaRepository  extends JpaRepository<ItemVenda, Long> {
    @Query
    public List<ItemVenda> findById(long Id);

/*
    @Query
    public List<ItemVenda> findByQuantidade(int quantidade);

    @Query
    public List<ItemVenda> findByValor_unitario(double valor_unitario);

    @Query
    public List<ItemVenda> findByValor_total(double valor_total);
*/



}