package models;

import java.time.LocalDate;

public class Cartao {

    private Conta conta;
    private LocalDate dataAprovação;
    private String numero;
    private String cvv;
    private LocalDate vencimento;

    public Cartao(Conta conta, LocalDate dataAprovação, String numero, String cvv, LocalDate vencimento) {
        this.conta = conta;
        this.dataAprovação = dataAprovação;
        this.numero = numero;
        this.cvv = cvv;
        this.vencimento = vencimento;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public LocalDate getDataAprovação() {
        return dataAprovação;
    }

    public void setDataAprovação(LocalDate dataAprovação) {
        this.dataAprovação = dataAprovação;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }
}
