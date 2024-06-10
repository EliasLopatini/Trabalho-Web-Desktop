package br.unipar.trabalhopdvspring.services;


import br.unipar.trabalhopdvspring.domain.Produto;
import br.unipar.trabalhopdvspring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto getById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto insert(Produto produto) {
        validate(produto);
        produtoRepository.save(produto);
        return produto;
    }
    private void validate(Produto produto) {

    }
    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void delete(long id) {
        produtoRepository.deleteById(id);
    }

}

