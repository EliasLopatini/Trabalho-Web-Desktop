package br.unipar.trabalhopdvspring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 5, max = 100)
    private String nome;

    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 10, max = 11)
    private String telefone;

    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    public Cliente(long id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @NotBlank @NotEmpty @Length(min = 5, max = 100)
    String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank @NotEmpty @Length(min = 5, max = 100)
                        String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank @NotEmpty @Length(min = 10, max = 11)
    String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull @NotBlank @NotEmpty @Length(min = 10, max = 11)
    String telefone) {
        this.telefone = telefone;
    }

    public @NotNull @NotBlank @NotEmpty String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @NotBlank @NotEmpty String email) {
        this.email = email;
    }
}
