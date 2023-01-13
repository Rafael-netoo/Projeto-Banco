package exception;

public class ElementoNaoExisteException extends Exception{
    private Object elemento;

    public ElementoNaoExisteException(Object obj) {
        super("Objeto não existe no repositório");
        this.elemento = obj;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}
