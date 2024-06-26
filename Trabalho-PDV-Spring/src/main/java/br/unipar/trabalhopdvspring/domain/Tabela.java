package br.unipar.trabalhopdvspring.domain;

import jakarta.persistence.*;

@Entity
public class Tabela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Produto produto;


    public Tabela() {
    }

    public Tabela(Long id, Cliente cliente, Produto produto) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}

