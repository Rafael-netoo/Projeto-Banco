package models;

import java.time.LocalDate;

public class Cliente extends Usuario{

    private String profissao;
    private double renda;
    private String endereco;

    public Cliente(String nome, LocalDate datadeNascimento, String cpf, String codigo, String genero,String email,String senha, String profissao , double renda ,String endereco) {
        super(nome, datadeNascimento, cpf, codigo, genero,email,senha);
        this.endereco = endereco;
        this.renda = renda;
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
