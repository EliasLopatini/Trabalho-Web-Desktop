package br.unipar.trabalhopdvspring.services;


import br.unipar.trabalhopdvspring.domain.Cliente;
import br.unipar.trabalhopdvspring.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
    public class ClienteService {

        @Autowired
        private ClienteRepository clienteRepository;

        public Cliente getById(Long id) {
            Optional<Cliente> cliente = clienteRepository.findById(id);

            return cliente.orElse(null);
        }

        public List<Cliente> getAll() {
            return clienteRepository.findAll();
        }

        public Cliente insert(Cliente cliente) {
            validate(cliente);
            clienteRepository.save(cliente);
            return cliente;
        }
        private void validate(Cliente cliente) {

        }
        public Cliente update(Cliente cliente) {
            return clienteRepository.save(cliente);
        }

        public void delete(long id) {
            clienteRepository.deleteById(id);
        }

    }

