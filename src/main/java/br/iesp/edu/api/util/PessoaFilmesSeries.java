package br.iesp.edu.api.util;

import br.iesp.edu.api.enums.FilmeSerie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFilmesSeries {
    private Integer id;
    private FilmeSerie filmeSerie;
}
