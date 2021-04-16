package List;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList<E> implements InterfazDoubleLinkedList<E> {
    int size;
    Nodo<E> head;
    Nodo<E> tail;

    public DoubleLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }


    @Override
    public void addFirst(E elemento) {
        // Esto añade por la izquierda.
        if (this.isEmpty()) {
            Nodo<E> newnode = new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setPrev(null);
            newnode.setNext(null);
            this.head = newnode;
            this.tail = newnode;
            this.size = 1;
        }
        else {
            Nodo<E> newnode = new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setNext(this.head);
            newnode.setPrev(null);
            this.head.setPrev(newnode);
            this.head = newnode;
            this.size ++;
        }
    }

    @Override
    public void addLast(E elemento) {
        if (this.isEmpty()) {
            Nodo<E> newnode = new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setPrev(null);
            newnode.setNext(null);
            this.tail = newnode;
            this.head = newnode;
            this.size = 1;
        }
        else {
            Nodo<E> newnode = new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setPrev(this.tail);
            newnode.setNext(null);
            this.tail.setNext(newnode);
            this.tail = newnode;
            this.size ++;
        }

    }

    @Override
    public void add(E elemento, int index) {
        if (index == 0) {
            this.addFirst(elemento);
        }
        else if (index == this.size) {
            this.addLast(elemento);
        }
        else if (index > this.size) {
            System.out.println("El indice es incorrecto.");
        }
        else {
            DoubleLinkedList<E> nuevalista = new DoubleLinkedList<E>();
            int contador = 0;
            while (this.isEmpty() == false) {
                if (index == contador) {
                    nuevalista.addLast(elemento);
                    contador ++;
                }
                else {
                    nuevalista.addLast(this.getFirst());
                    this.removeFirst();
                    contador ++;
                }
            } // Fin del while.
            this.head = nuevalista.head;
            this.tail = nuevalista.tail;
            this.size = nuevalista.size;
        }
    }

    @Override
    public void removeFirst() {
        if (this.isEmpty()) {
            System.out.println("La lista está vacía.");
        }
        else {
            this.head = head.getNext();
            this.size --;
        }
    }

    @Override
    public void removeLast() {
        if (this.isEmpty()) {
            System.out.println("La lista está vacía.");
        }
        else {
            this.tail = tail.getPrev();
            this.size --;
        }
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            this.removeFirst();
        }
        else if (index == this.size - 1) {
            this.removeLast();
        }
        else if (index >= this.size - 1) {
            System.out.println("El indice es incorrecto.");
        }
        else {
            DoubleLinkedList<E> nuevalista = new DoubleLinkedList<E>();
            int contador = 0;
            while (this.isEmpty() == false) {
                if (index == contador) {
                    this.removeFirst();
                    contador ++;
                }
                else {
                    nuevalista.addLast(this.getFirst());
                    this.removeFirst();
                    contador ++;
                }
            } // Fin del while.
            this.head = nuevalista.head;
            this.tail = nuevalista.tail;
            this.size = nuevalista.size;
        }
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
    public int size() {
        return size;
    }

    @Override
    public E getFirst() {
        E elemento;
        if (this.isEmpty()) {
            elemento = null;
            System.out.println("La lista está vacía.");
        }
        else {
            elemento = head.getElemento();
        }
        return elemento;
    }

    @Override
    public E getLast() {
        E elemento;
        if (this.isEmpty()) {
            elemento = null;
            System.out.println("La lista está vacía.");
        }
        else {
            elemento = tail.getElemento();
        }
        return elemento;
    }

    @Override
    public E get(int index) {
        E elemento = null;
        if (index == 0) {
            elemento = this.getFirst();
        }
        else if (index == this.size - 1) {
            this.getLast();
        }
        else if (index >= this.size - 1) {
            System.out.println("El índice es incorrecto.");
        }
        else {
            DoubleLinkedList<E> nuevalista = new DoubleLinkedList<E>();
            int contador = 0;
            while (this.isEmpty() == false) {
                if (index == contador) {
                    elemento = this.getFirst();
                    nuevalista.addLast(this.getFirst());
                    this.removeFirst();
                    contador ++;
                }
                else {
                    nuevalista.addLast(this.getFirst());
                    this.removeFirst();
                    contador ++;
                }
            } // Fin del while.
            this.head = nuevalista.head;
            this.tail = nuevalista.tail;
            this.size = nuevalista.size;
        }
        return elemento;
    }

    @Override
    public boolean contains(E elemento) {
        return false;
    }

    public Iterable<Nodo<E>> iterator() {
        List<E> listaresultado = new ArrayList<E>();
        DoubleLinkedList<E> dl2aux = new DoubleLinkedList<E>();
        while (this.isEmpty() == false) {
            // Consultar.
            Nodo<E> nodo = new Nodo<E>();
            nodo = this.head;
            listaresultado.add((E) nodo);
            // Construir la lista.
            dl2aux.addLast(this.getFirst());
            // Destruir la lista.
            this.removeFirst();
        }
        // Asignar volvemos a tener la lista 1 intacta.
        this.head = dl2aux.head;
        this.tail = dl2aux.tail;
        this.size = dl2aux.size;

        return (Iterable<Nodo<E>>) listaresultado;
    }
}
