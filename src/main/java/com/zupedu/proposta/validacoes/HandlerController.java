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
    public ResponseEntity<?> exceptionHandler(MethodArgumentNotValidException e, BindingResult result) {
        return getListResponseEntity(result);
    }

    @ExceptionHandler(ExceptionPersonalizada.class)
    public ResponseEntity<?> handlerPersonalizado(ExceptionPersonalizada e) {
        HandlerErrorMessage erroPersonalizado = new HandlerErrorMessage(e.getLocalizedMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(erroPersonalizado);
    }

    private ResponseEntity<?> getListResponseEntity(BindingResult result) {
        List<HandlerError> errorHandlers = result.getFieldErrors()
                .stream()
                .map(HandlerError::new)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorHandlers);
    }

}
