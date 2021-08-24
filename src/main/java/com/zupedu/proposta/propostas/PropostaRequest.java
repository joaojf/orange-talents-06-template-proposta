package com.zupedu.proposta.propostas;

import com.zupedu.proposta.validacoes.anotacoes.DocumentoValido;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;

public class PropostaRequest {

    @DocumentoValido
    @NotBlank
    private String cpfOuCnpj;

    @NotBlank @NotNull @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    @NotNull @PositiveOrZero
    private BigDecimal salario;

    public Proposta converte() {
        return new Proposta(this.cpfOuCnpj, this.email, this.nome, this.endereco, this.salario);
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
        PropostaRequest that = (PropostaRequest) o;
        return cpfOuCnpj.equals(that.cpfOuCnpj) && email.equals(that.email) && nome.equals(that.nome) && endereco.equals(that.endereco) && salario.equals(that.salario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpfOuCnpj, email, nome, endereco, salario);
    }
}
