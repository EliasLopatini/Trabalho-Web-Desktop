package br.unipar.trabalhopdvspring.repositories;

import br.unipar.trabalhopdvspring.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface ProdutoRepository extends JpaRepository<Produto, Long> {

        @Query
        public List<Produto> findById(long Id);

        @Query
        public List<Produto> findByDescricao(String descricao);

        @Query
        public List<Produto> findByPreco(Double preco);

        @Query
        public List<Produto> findByCategoria(String Categoria);

}
