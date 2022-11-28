package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Pessoa;
import br.iesp.edu.api.enums.FilmeSerie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Pessoa findByCpfOuCnpj(String cpfOuCnpj);
}
