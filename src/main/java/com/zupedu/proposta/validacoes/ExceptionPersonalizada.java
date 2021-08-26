package com.zupedu.proposta.validacoes;

import org.springframework.http.HttpStatus;

public class ExceptionPersonalizada extends RuntimeException {

    private final HttpStatus httpStatus;

    public ExceptionPersonalizada(String mensagem, HttpStatus httpStatus) {
        super(mensagem);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}