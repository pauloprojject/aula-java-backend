package br.iesp.edu.api.enums;

public enum Perfil {
    USUARIO("Usuario"),
    ADMIN("Admin");

    private final String descricao;

    private Perfil(String descricao){
        this.descricao = descricao;
    }
}
