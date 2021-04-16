package Cola;

public class QueueDoble<E> implements InterfazQueueDoble<E>{
    NodoColaDoble<E> head;
    NodoColaDoble<E> tail;
    int size;

    @Override
    public int Size() {
        return size;
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
    public E Front() {
        E elemento;
        if (this.isEmpty()) {
            elemento = null;
            System.out.println("La cola está vacía.");
        }
        else {
            elemento = this.head.getElemento();
        }
        return elemento;
    }

    @Override
    public E Tail() {
        E elemento;
        if (this.isEmpty()) {
            elemento = null;
            System.out.println("La cola está vacía.");
        }
        else {
            elemento = this.tail.getElemento();
        }
        return elemento;
    }

    @Override
    public void EnQueue(E elemento) {
        if (this.isEmpty()) {
            NodoColaDoble<E> newnode = new NodoColaDoble<E>();
            newnode.setElemento(elemento);
            newnode.setNext(null);
            newnode.setPrev(null);
            this.head = newnode;
            this.tail = newnode;
            this.size = 1;
        }
        else {
            NodoColaDoble<E> newnode = new NodoColaDoble<E>();
            newnode.setElemento(elemento);
            newnode.setNext(null);
            newnode.setPrev(tail);
            this.tail.setNext(newnode);
            tail = newnode;
            this.size ++;
        }
    }

    @Override
    public void DeQueue() {
        if (this.isEmpty()) {
            System.out.println("La cola está vacía.");
        }
        else {
            head = head.getNext();
            this.size --;
        }
    }
}
