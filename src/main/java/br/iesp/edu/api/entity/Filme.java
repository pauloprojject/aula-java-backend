package br.iesp.edu.api.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Filme {

    @Id
    @GeneratedValue
    private Integer Id;
    private String Titulo;
    private String Genero;
    private Integer Ano;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "PessoaFilme")
    private Set<PessoaFilme> favoritos;
}
