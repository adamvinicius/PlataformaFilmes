package br.com.chronosacademy.controller.dto;

import br.com.chronosacademy.model.Categoria;

public class CategoriaDto {
    private String tipo;

    public CategoriaDto(Categoria categoria) {
        this.tipo = categoria.getTipo();
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
