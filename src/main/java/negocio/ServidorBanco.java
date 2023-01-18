package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.ElementoJaExisteException;
import exception.ElementoNaoExisteException;
import models.*;

public class ServidorBanco {

    private static ServidorBanco instance;

    private ControladorCartoes controladorCartoes;
    private ControladorContas controladorContas;
    private ControladorUsuarios controladorUsuarios;

    private ServidorBanco() {
        this.controladorCartoes = ControladorCartoes.getInstance();
        this.controladorContas = ControladorContas.getInstance();
        this.controladorUsuarios = ControladorUsuarios.getInstance();
    }

    public static ServidorBanco getInstance() {
        if (instance == null) {
            instance = new ServidorBanco();
        }
        return instance;
    }

    public void inserir(Cartao obj) throws ElementoJaExisteException {
        this.controladorCartoes.inserir(obj);
    }

    public List<Cartao> cartaoListar() {
        return this.controladorCartoes.listar();
    }

    public void remover(Cartao obj) throws ElementoNaoExisteException {
        this.controladorCartoes.remover(obj);
    }

    public void atualizar(Cartao newObj) throws ElementoNaoExisteException {
        this.controladorCartoes.atualizar(newObj);
    }

    public void inserir(Conta obj) throws ElementoJaExisteException {
        this.controladorContas.inserir(obj);
    }

    public List<Conta> contaListar() {
        return this.controladorContas.listar();
    }

    public void remover(Conta obj) throws ElementoNaoExisteException {
        this.controladorContas.remover(obj);
    }

    public void atualizar(Conta newObj) throws ElementoNaoExisteException {
        this.controladorContas.atualizar(newObj);
    }

    public void inserir(Usuario obj) throws ElementoJaExisteException {
        this.controladorUsuarios.inserir(obj);
    }

    public List<Usuario> usuarioListar() {
        return this.controladorUsuarios.listar();
    }

    public void remover(Usuario obj) throws ElementoNaoExisteException {
        this.controladorUsuarios.remover(obj);
    }

    public void atualizar(Usuario newObj) throws ElementoNaoExisteException {
        this.controladorUsuarios.atualizar(newObj);
    }

    public void transferir(Conta receptor, Conta pagador, double saldo){
        List<Conta> listConta =  controladorContas.listar();

        for(int i = 0; i < listConta.size(); i++){

            if(listConta.get(i).getAgencia().equals(receptor.getAgencia()) && listConta.get(i).getNumero().equals(receptor.getNumero())){
                if(pagador.getSaldo() >= saldo){
                    double novoSaldo = pagador.getSaldo() - saldo;
                    pagador.setSaldo(novoSaldo);
                    Transacao transacaoPagador = new Transacao(receptor.getCliente().getNome(), saldo);
                    pagador.getTransacoes().add(transacaoPagador);

                    double novoSaldoReceptor = receptor.getSaldo() + saldo;
                    receptor.setSaldo(novoSaldoReceptor);
                    Transacao transacaoReceptor = new Transacao(pagador.getCliente().getNome(), saldo);
                    receptor.getTransacoes().add(transacaoReceptor);
                }
            }

        }
    }

    public void fazerPix(Conta conta ,String pix ,double valor){
        List<Conta> listContas  = new ArrayList<>();
        listContas = controladorContas.listar();
        for(int i = 0; i < listContas.size(); i ++){
            for(int j = 0 ; j < controladorContas.listar().get(i).getPix().size() ; j++ ){
                if(controladorContas.listar().get(i).getPix().get(j).equals(pix)){
                    //  for(int k = 0 ; k < listContas.size(); k++){
                    //   if(repositorioDeContas.listar().get(k).equals(conta) && conta.getSaldo() >= valor){
                    if(conta.getSaldo() >= valor){
                        controladorContas.listar().get(i).setSaldo(controladorContas.listar().get(i).getSaldo() + valor);
                        conta.setSaldo(conta.getSaldo() - valor);

                        String nomeReceptor = listContas.get(i).getCliente().getNome();
                        Transacao transacaoPagador = new Transacao(nomeReceptor, valor);
                        conta.getTransacoes().add(transacaoPagador);

                        Transacao transacaoReceptor = new Transacao(conta.getCliente().getNome(), valor);
                        listContas.get(i).getTransacoes().add(transacaoReceptor);
                    }
                    //  }

                }
            }
        }
    }

    public void jurosPoupança(Conta conta){
        LocalDate ultimoJuros = conta.getDtbertura();
        if(conta instanceof ContaPoupanca){
            if(LocalDate.now().getDayOfYear() == ultimoJuros.getDayOfYear() + 31){
                conta.setSaldo(conta.getSaldo() * 0.05);
                conta.setDtbertura(ultimoJuros);
            }
        }
    }

    public void gerarExtrato(Conta conta){

        conta.getTransacoes().toString();

    }

}
