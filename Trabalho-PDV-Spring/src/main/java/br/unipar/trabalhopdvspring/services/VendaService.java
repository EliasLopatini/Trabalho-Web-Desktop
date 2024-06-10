package br.unipar.trabalhopdvspring.services;
import br.unipar.trabalhopdvspring.domain.Venda;
import br.unipar.trabalhopdvspring.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public Venda getById(Long id) {
        Optional<Venda> venda = vendaRepository.findById(id);
        return venda.orElse(null);
    }

    public List<Venda> getAll() {
        return vendaRepository.findAll();
    }

    public Venda insert(Venda venda) {
        validate(venda);
        vendaRepository.save(venda);
        return venda;
    }
    private void validate(Venda venda) {

    }
    public Venda update(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void delete(long id) {
        vendaRepository.deleteById(id);
    }
}
