package org.serratec.java2.backend.contas.bancarias.repository;

import org.serratec.java2.backend.contas.bancarias.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Integer> {

}
