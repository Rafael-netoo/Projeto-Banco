package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import exception.ElementoJaExisteException;
import exception.ElementoNaoExisteException;
import models.Conta;

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

    public void transferir(Conta recebe, Conta envia, double saldo){
        List<Conta> listConta =  repositorioDeContas.listar();

        for(int i = 0; i < listConta.size(); i++){

            if(listConta.get(i).getAgencia().equals(recebe.getAgencia()) && listConta.get(i).getNumero().equals(recebe.getNumero())){
                if(envia.getSaldo() >= saldo){
                    double novoSaldo = envia.getSaldo() - saldo;
                    envia.setSaldo(novoSaldo);
                    double novoSaldoReceptor = recebe.getSaldo() + saldo;
                    recebe.setSaldo(novoSaldoReceptor);
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
                    }
                    //  }

                }
            }
        }
    }

}
