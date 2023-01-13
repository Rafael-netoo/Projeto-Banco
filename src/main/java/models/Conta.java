package models;

import java.util.List;

public abstract class Conta {

    private Cliente cliente;
    private String  numero;
    private String  agencia;
    private String tipo;
    private List<String> pix;

    public Conta(Cliente cliente, String numero, String agencia, String tipo, List<String> pix) {
        this.cliente = cliente;
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
        this.pix = pix;
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
}
