package models;

public class Transacao {
    private String nome;
    private double saldo;

    public Transacao(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                nome +
                " ........... R$ " + saldo +
                '}';
    }
}
