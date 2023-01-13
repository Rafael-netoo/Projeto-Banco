package models;

import java.time.LocalDate;

public abstract class Usuario {
    private String nome;
    private LocalDate datadeNascimento;
    private String cpf;
    private String codigo;
    private String email;
    private String senha;

    private String genero;

    public Usuario(String nome, LocalDate datadeNascimento, String cpf, String codigo,String genero,String email,String senha) {
        this.nome = nome;
        this.datadeNascimento = datadeNascimento;
        this.cpf = cpf;
        this.codigo = codigo;
        this.genero = genero;
        this.senha = senha;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDatadeNascimento() {
        return datadeNascimento;
    }

    public void setDatadeNascimento(LocalDate datadeNascimento) {
        this.datadeNascimento = datadeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
