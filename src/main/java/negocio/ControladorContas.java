package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import exception.ElementoJaExisteException;
import exception.ElementoNaoExisteException;
import models.Conta;
import models.ContaPoupanca;
import models.Transacao;

public class ControladorContas {

    private IRepositorioGenerico<Conta> repositorioDeContas;
    private static ControladorContas instance;

    private ControladorContas() {
        this.repositorioDeContas = new RepositorioGenerico<>("contas.dat");
    }

    public static ControladorContas getInstance() {
        if (instance == null) {
            instance = new ControladorContas();
        }
        return instance;
    }

    public void inserir(Conta obj) throws ElementoJaExisteException {
        this.repositorioDeContas.inserir(obj);
    }

    public List<Conta> listar() {
        return this.repositorioDeContas.listar();
    }

    public void remover(Conta obj) throws ElementoNaoExisteException {
        this.repositorioDeContas.remover(obj);
    }

    public void atualizar(Conta newObj) throws ElementoNaoExisteException {
        this.repositorioDeContas.atualizar(newObj);
    }

    public void transferir(Conta receptor, Conta pagador, double saldo){
        List<Conta> listConta =  repositorioDeContas.listar();

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
        listContas = repositorioDeContas.listar();
        for(int i = 0; i < listContas.size(); i ++){
            for(int j = 0 ; j < repositorioDeContas.listar().get(i).getPix().size() ; j++ ){
                if(repositorioDeContas.listar().get(i).getPix().get(j).equals(pix)){
                    //  for(int k = 0 ; k < listContas.size(); k++){
                    //   if(repositorioDeContas.listar().get(k).equals(conta) && conta.getSaldo() >= valor){
                    if(conta.getSaldo() >= valor){
                        repositorioDeContas.listar().get(i).setSaldo(repositorioDeContas.listar().get(i).getSaldo() + valor);
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
