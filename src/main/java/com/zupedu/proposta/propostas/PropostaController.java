package com.zupedu.proposta.propostas;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class PropostaController {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping(value = "/propostas")
    public ResponseEntity<?> novaProposta(@Valid @RequestBody PropostaRequest propostaRequest) {
        Proposta proposta = propostaRequest.converte();
        entityManager.persist(proposta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
