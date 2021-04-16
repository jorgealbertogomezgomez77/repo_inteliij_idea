package Cola;

public interface InterfazQueueDoble<E> {
    /*
    * size() -> Devuelve el tamanio de la lista.
    * isEmpty() -> Si está vacía.
    * front() -> Primer elemento.
    * enqueue() -> Poner e la cola.
    * dequeue() -> Devuelve el último elemento.
    */

    public int Size();
    public boolean isEmpty();
    public E Front();
    public E Tail();
    public void EnQueue(E elemento);
    public void DeQueue();
}
