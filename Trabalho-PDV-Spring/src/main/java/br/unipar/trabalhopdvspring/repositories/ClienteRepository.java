package br.unipar.trabalhopdvspring.repositories;

import br.unipar.trabalhopdvspring.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query
    public List<Cliente> findById(long Id);
    //CASO DER ERRO COLOCAR INTEGER AQUI

    @Query
    public List<Cliente> findByNome(String nome);

    @Query
    public List<Cliente> findByTelefone(String telefone);

    @Query
    public List<Cliente> findByEmail(String email);

}
