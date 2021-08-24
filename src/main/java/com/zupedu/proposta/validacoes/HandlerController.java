package com.zupedu.proposta.validacoes;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validacao(MethodArgumentNotValidException e, BindingResult result) {
        if (result.hasErrors()) {
            List<HandlerError> erros = result.getFieldErrors()
                    .stream()
                    .map(HandlerError::new)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(erros);
        } return null;
    }

}
