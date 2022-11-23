package br.iesp.edu.api.enums;

public enum FilmeSerie {
    FILME("Filme"),
    SERIE("Serie");

    private final String descricao;

    private FilmeSerie(String descricao){
        this.descricao = descricao;
    }
}
