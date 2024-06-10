package br.unipar.trabalhopdvspring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "VENDA")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String observacoes;


  //  private Date data;



    private double total;

    @ManyToOne
    private Cliente cliente;

    public Venda(Cliente cliente, double total, String observacoes, long id) {
        this.cliente = cliente;
        this.total = total;
       // this.data = data;
        this.observacoes = observacoes;
        this.id = id;
    }

    public Venda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes( String observacoes) {
        this.observacoes = observacoes;
    }

   // public  Date getData() {
   //     return data;
   // }

  // public void setData( Date data) {
   //     this.data = data;
   // }


    public double getTotal() {
        return total;
    }

    public void setTotal( double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
