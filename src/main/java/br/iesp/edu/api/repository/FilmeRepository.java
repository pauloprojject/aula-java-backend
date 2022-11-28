package br.iesp.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.iesp.edu.api.entity.Filme;
import br.iesp.edu.api.entity.Pessoa;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer>{
    // public Pessoa findByCpf(String cpf);
}
