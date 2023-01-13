package dados;

import exception.ElementoJaExisteException;
import exception.ElementoNaoExisteException;

import java.util.List;

public interface IRepositorioGenerico<R> {
    void inserir(R obj) throws ElementoJaExisteException;

    List<R> listar();

    void remover(R obj) throws ElementoNaoExisteException;

    void atualizar(R newObj) throws ElementoNaoExisteException;
}
