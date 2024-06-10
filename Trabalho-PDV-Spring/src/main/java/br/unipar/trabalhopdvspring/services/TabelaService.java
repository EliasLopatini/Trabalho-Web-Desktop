package br.unipar.trabalhopdvspring.services;

import br.unipar.trabalhopdvspring.domain.Produto;
import br.unipar.trabalhopdvspring.domain.Tabela;
import br.unipar.trabalhopdvspring.repositories.ProdutoRepository;
import br.unipar.trabalhopdvspring.repositories.TabelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TabelaService {

    @Autowired
    private TabelaRepository tabelaRepository;

    public Tabela getById(Long id) {
        Optional<Tabela> tabela = tabelaRepository.findById(id);
        return tabela.orElse(null);
    }

    public List<Tabela> getAll() {
        return tabelaRepository.findAll();
    }

    private void validate(Tabela tabela) {
    }


    public Tabela update(Tabela tabela) {
        return tabelaRepository.save(tabela);
    }



}