package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta {

    private Cliente cliente;
    private String  numero;
    private String  agencia;
    private String tipo;
    private List<String> pix;
    private  double saldo;
    private List<Transacao> transacoes;

    private LocalDate dtbertura;

    public Conta(Cliente cliente, String numero, String agencia, String tipo, List<String> pix, double saldo) {
        this.cliente = cliente;
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
        this.pix = pix;
        this.saldo = saldo;
        this.transacoes = new ArrayList<>();
        this.dtbertura = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<String> getPix() {
        return pix;
    }

    public void setPix(List<String> pix) {
        this.pix = pix;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public LocalDate getDtbertura() {
        return dtbertura;
    }

    public void setDtbertura(LocalDate dtbertura) {
        this.dtbertura = dtbertura;
    }
}
