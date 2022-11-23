package br.iesp.edu.api.entity;

import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.iesp.edu.api.enums.FilmeSerie;
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
    @JsonFormat(pattern = "HH:mm:ss[.SSS][.SS][.S]")
    private LocalTime duracao;
    private Integer Relevancia;
    @Length(min = 1, max = 1000)
    private String Sinopse;
    private String Trailer;
    @Null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToMany(mappedBy = "filmes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pessoa> pessoas;
    @Enumerated(EnumType.STRING)
    @Column(name = "filme_serie")
    private FilmeSerie FilmeSerie;
}
