package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Pessoa;
import br.iesp.edu.api.enums.FilmeSerie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    // @Query("SELECT p,"
    // +"             f"
    // +"      FROM pessoa AS p"
    // +"      INNER JOIN pessoa_filme AS pf ON p.id = pf.pessoa_id"
    // +"      INNER JOIN filme AS f ON pf.filme_id = f.id;"
    // +"      WHERE EXISTS (SELECT pf.pessoa_id FROM pessoa_filme AS pf INNER JOIN pessoa AS p on pf.pessoa_id = p.id WHERE p.id = ?1 AND pf.pessoa_id = p.id)"
    // +"      AND f.filme_serie LIKE '%?2%'")
    // public Pessoa FilterFilmeByFilmeSerie(Integer id, String filmeSerie);
}
