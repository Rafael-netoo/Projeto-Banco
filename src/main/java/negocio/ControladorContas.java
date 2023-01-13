package negocio;

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
}
