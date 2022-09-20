package br.iesp.edu.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
