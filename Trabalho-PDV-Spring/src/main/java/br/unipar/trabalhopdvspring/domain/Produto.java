package br.unipar.trabalhopdvspring.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "PRODUTO")

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 10, max = 100)
    private String descricao;


    private double preco;

    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 5, max = 100)
    private String categoria;

    public Produto(long id, String descricao, double preco, String categoria) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull @NotBlank @NotEmpty @Length(min = 10, max = 100)
    String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank @NotEmpty @Length(min = 10, max = 100)
                             String descricao) {
        this.descricao = descricao;
    }


    public double getPreco() {
        return preco;
    }

    public void setPreco( double preco) {
        this.preco = preco;
    }

    public @NotNull @NotBlank @NotEmpty @Length(min = 5, max = 100)
    String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull @NotBlank @NotEmpty @Length(min = 5, max = 100)
                             String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
