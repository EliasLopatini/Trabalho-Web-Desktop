package br.unipar.trabalhopdvspring.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ITEMVENDA")
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    private int quantidade;

    @NotNull
    @NotBlank
    @NotEmpty
    private double valor_unitario;

    @NotNull
    @NotBlank
    @NotEmpty
    private double valor_total;

    @ManyToOne
    private Venda idVenda;

    @ManyToOne
    private Produto produto;

    public ItemVenda() {
    }

    public ItemVenda(long id, int quantidade, double valor_unitario, double valor_total, Venda idVenda, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
        this.idVenda = idVenda;
        this.produto = produto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull @NotBlank @NotEmpty int quantidade) {
        this.quantidade = quantidade;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(@NotNull @NotBlank @NotEmpty double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(@NotNull @NotBlank @NotEmpty double valor_total) {
        this.valor_total = valor_total;
    }

    public Venda getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Venda idVenda) {
        this.idVenda = idVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto idProduto) {
        this.produto = idProduto;
    }
}
