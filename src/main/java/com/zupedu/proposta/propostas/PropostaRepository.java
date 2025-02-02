package com.zupedu.proposta.propostas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, String> {
    boolean existsByCpfOuCnpj(String cpfOuCnpj);
}
