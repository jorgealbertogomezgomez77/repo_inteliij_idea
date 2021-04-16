package Pila;

public interface InterfazPila<E> {

    public void Push(E elemento);
    public void Pop();
    public int Size();
    public boolean isEmpty();
    public E Top();
}
