package dados;

import exception.ElementoJaExisteException;
import exception.ElementoNaoExisteException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioGenerico<R> {
    protected List<R> elementos;

    private String filename;

    @SuppressWarnings("unchecked")
    public RepositorioGenerico(String filename) {
        this.filename = filename;
        this.elementos = new ArrayList<>();

        Object listaElementos = RepositorioFileUtil.lerDoArquivo(this.filename);
        if (listaElementos != null && listaElementos instanceof List<?>){
            this.elementos = (List<R>) listaElementos;
        }
    }

    //@Override
    public void inserir(R novoObj) throws ElementoJaExisteException {
        if (!this.elementos.contains(novoObj)) {
            this.elementos.add(novoObj);
        } else {
            throw new ElementoJaExisteException(novoObj);
        }

        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }

   // @Override
    public List<R> listar() {
        return Collections.unmodifiableList(this.elementos);
    }

   // @Override
    public void remover(R obj) throws ElementoNaoExisteException {
        if (this.elementos.contains(obj)) {
            this.elementos.remove(this.elementos.indexOf(obj));
        } else {
            throw new ElementoNaoExisteException(obj);
        }

        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }

    //@Override
    public void atualizar(R newObj) throws ElementoNaoExisteException {
        if (this.elementos.contains(newObj)) {
            int indice = this.elementos.indexOf(newObj);
            this.elementos.set(indice, newObj);
        } else {
            throw new ElementoNaoExisteException(newObj);
        }

        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }

}
