package Cola;

public class NodoColaDoble<E> {
    E elemento;
    NodoColaDoble<E> prev;
    NodoColaDoble<E> next;

    public NodoColaDoble() {
        elemento = null;
        prev = null;
        next = null;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public NodoColaDoble<E> getPrev() {
        return prev;
    }

    public void setPrev(NodoColaDoble<E> prev) {
        this.prev = prev;
    }

    public NodoColaDoble<E> getNext() {
        return next;
    }

    public void setNext(NodoColaDoble<E> next) {
        this.next = next;
    }
}
