package com.zupedu.proposta.propostas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Proposta {

    @Id
    private String id = UUID.randomUUID().toString().replace("-","");

    @Column(nullable = false)
    private String cpfOuCnpj;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private BigDecimal salario;

    public Proposta(String cpfOuCnpj, String email, String nome, String endereco, BigDecimal salario) {
        this.cpfOuCnpj = cpfOuCnpj;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposta proposta = (Proposta) o;
        return id.equals(proposta.id) && cpfOuCnpj.equals(proposta.cpfOuCnpj) && email.equals(proposta.email) && nome.equals(proposta.nome) && endereco.equals(proposta.endereco) && salario.equals(proposta.salario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpfOuCnpj, email, nome, endereco, salario);
    }
}
