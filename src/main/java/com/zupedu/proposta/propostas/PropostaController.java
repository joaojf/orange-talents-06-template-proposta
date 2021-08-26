package com.zupedu.proposta.propostas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class PropostaController {

    private final PropostaRepository propostaRepository;

    @Autowired
    public PropostaController(PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

    @Transactional
    @PostMapping(value = "/propostas")
    public ResponseEntity<?> novaProposta(@Valid @RequestBody PropostaRequest propostaRequest) {
        Proposta proposta = propostaRequest.converte(propostaRepository);
        propostaRepository.save(proposta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
