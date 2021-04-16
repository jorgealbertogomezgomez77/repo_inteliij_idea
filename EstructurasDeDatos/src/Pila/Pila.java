package Pila;

public class Pila<E> implements InterfazPila<E> {
    private int size;
    NodoPila<E> cima;

    public Pila() {
        size = 0;
        cima = null;
    }

    @Override
    public void Push(E elemento) {
        if (this.isEmpty()) {
            NodoPila<E> pl = new NodoPila<E>();
            pl.setElemento(elemento);
            pl.setPrev(null);
            cima = pl;
            this.size = 1;
        }
        else {
            NodoPila<E> pl = new NodoPila<E>();
            pl.setElemento(elemento);
            pl.setPrev(cima);
            cima = pl;
            this.size = size + 1;
        }
    }

    @Override
    public void Pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
        }
        else {
            cima = cima.getPrev();
            this.size --;
        }
    }

    @Override
    public int Size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public E Top() {
        E elemento;
        if (this.isEmpty()) {
            elemento = null;
            System.out.println("La pila está vacía.");
        }
        else {
            elemento = cima.getElemento();
        }
        return elemento;
    }
}
