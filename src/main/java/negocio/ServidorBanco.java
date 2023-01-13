package negocio;

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

}
