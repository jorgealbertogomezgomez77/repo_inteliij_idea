package List;

public class Nodo<E> {
    E elemento;
    Nodo<E> prev;
    Nodo<E> next;

    public Nodo() {
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

    public Nodo<E> getPrev() {
        return prev;
    }

    public void setPrev(Nodo<E> prev) {
        this.prev = prev;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }
}
