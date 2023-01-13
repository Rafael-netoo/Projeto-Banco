package negocio;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import exception.ElementoJaExisteException;
import exception.ElementoNaoExisteException;
import models.Cartao;

public class ControladorCartoes {

    private IRepositorioGenerico<Cartao> repositorioDeCartoes;
    private static ControladorCartoes instance;

    private ControladorCartoes() {
        this.repositorioDeCartoes = new RepositorioGenerico<>("cartoes.dat");
    }

    public static ControladorCartoes getInstance() {
        if (instance == null) {
            instance = new ControladorCartoes();
        }
        return instance;
    }

    public void inserir(Cartao obj) throws ElementoJaExisteException {
        this.repositorioDeCartoes.inserir(obj);
    }

    public List<Cartao> listar() {
        return this.repositorioDeCartoes.listar();
    }

    public void remover(Cartao obj) throws ElementoNaoExisteException {
        this.repositorioDeCartoes.remover(obj);
    }

    public void atualizar(Cartao newObj) throws ElementoNaoExisteException {
        this.repositorioDeCartoes.atualizar(newObj);
    }
}
