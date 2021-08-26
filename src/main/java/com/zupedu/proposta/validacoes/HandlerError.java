package com.zupedu.proposta.validacoes;

import org.springframework.validation.FieldError;

public class HandlerError {

    private final String campo;
    private final String mensagem;

    public HandlerError(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public HandlerError(FieldError fieldError) {
        this.campo = fieldError.getField();
        this.mensagem = fieldError.getDefaultMessage();
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }

}
