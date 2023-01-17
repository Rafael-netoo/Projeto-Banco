package models;

import java.util.List;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente, String numero, String agencia, String tipo, List<String> pix,double saldo) {
        super(cliente, numero, agencia, tipo, pix, saldo);

    }


}
