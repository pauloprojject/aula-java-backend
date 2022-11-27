package br.iesp.edu.api.util;

import br.iesp.edu.api.entity.Filme;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeAdmin {
    private String cpf;
    private String senha;
    private Filme filme;
}
