package br.unipar.trabalhopdvspring.services;

import br.unipar.trabalhopdvspring.domain.ItemVenda;
import br.unipar.trabalhopdvspring.repositories.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public ItemVenda getById(Long  id) {
        Optional<ItemVenda> itemVenda = itemVendaRepository.findById(id);
        return itemVenda.orElse(null);
    }

    public List<ItemVenda> getAll() {
        return itemVendaRepository.findAll();
    }

    public ItemVenda insert(ItemVenda itemVenda) {
        validate(itemVenda);
        itemVendaRepository.save(itemVenda);
        return itemVenda;
    }
    private void validate(ItemVenda itemVenda) {

    }
    public ItemVenda update(ItemVenda itemVenda) {
        return itemVendaRepository.save(itemVenda);
    }

    public void delete(long id) {
        itemVendaRepository.deleteById(id);
    }

}