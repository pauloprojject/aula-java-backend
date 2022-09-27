package br.iesp.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.iesp.edu.api.entity.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer>{
    
}
