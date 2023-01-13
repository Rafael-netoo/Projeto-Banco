package exception;

public class ElementoJaExisteException extends Exception{

    private Object elemento;

    public ElementoJaExisteException(Object obj) {
        super("Objeto já existe no repositório");
        this.elemento = obj;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}
