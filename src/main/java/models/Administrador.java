package models;

import java.time.LocalDate;

public class Administrador extends Usuario{

    private String codigoEspecial;

    public Administrador(String nome, LocalDate datadeNascimento, String cpf, String codigo, String genero, String email, String senha) {
        super(nome, datadeNascimento, cpf, codigo, genero, email, senha);
    }
}
