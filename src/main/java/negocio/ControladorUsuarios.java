package negocio;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import exception.ElementoJaExisteException;
import exception.ElementoNaoExisteException;
import models.Usuario;

public class ControladorUsuarios {

    private IRepositorioGenerico<Usuario> repositorioDeUsuarios;
    private static ControladorUsuarios instance;

    private ControladorUsuarios() {
        this.repositorioDeUsuarios = new RepositorioGenerico<>("usuarios.dat");
    }

    public static ControladorUsuarios getInstance() {
        if (instance == null) {
            instance = new ControladorUsuarios();
        }
        return instance;
    }

    public void inserir(Usuario obj) throws ElementoJaExisteException {
        this.repositorioDeUsuarios.inserir(obj);
    }

    public List<Usuario> listar() {
        return this.repositorioDeUsuarios.listar();
    }

    public void remover(Usuario obj) throws ElementoNaoExisteException {
        this.repositorioDeUsuarios.remover(obj);
    }

    public void atualizar(Usuario newObj) throws ElementoNaoExisteException {
        this.repositorioDeUsuarios.atualizar(newObj);
    }

    public boolean validarLogin(String email, String senha) {
        boolean igual = false;

        List<Usuario> usuarios = repositorioDeUsuarios.listar();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getSenha().equals(senha)) {
                igual = true;
            }
        }
        return igual;
    }

}