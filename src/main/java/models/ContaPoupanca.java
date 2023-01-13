package models;

import java.util.List;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente, String numero, String agencia, String tipo, List<String> pix) {
        super(cliente, numero, agencia, tipo, pix);
    }
}
