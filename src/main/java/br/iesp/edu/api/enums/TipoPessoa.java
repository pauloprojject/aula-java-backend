package br.iesp.edu.api.enums;

import br.iesp.edu.api.interfaces.CnpjGroup;
import br.iesp.edu.api.interfaces.CpfGroup;
import lombok.Getter;

@Getter
public enum TipoPessoa {
    FISICA("Fisica", CpfGroup.class),
    JURIDICA("Juridica", CnpjGroup.class);

    private final String descricao;
    private final Class<?> group;

    private TipoPessoa(String descricao, Class<?> group) {
        this.descricao = descricao;
        this.group = group;
    }
}
