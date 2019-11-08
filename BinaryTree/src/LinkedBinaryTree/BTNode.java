package LinkedBinaryTree;

public class BTNode<E> implements Position<E> {
    private E elemento;
    private BTNode<E> right;
    private BTNode<E> left;
    private BTNode<E> parent;

    public BTNode() {
        elemento = null;
        right = null;
        left = null;
        parent = null;
    }

    public BTNode(E elemento, BTNode<E> right, BTNode<E> left, BTNode<E> parent) {
        this.elemento = elemento;
        this.right = right;
        this.left = left;
        this.parent = parent;
    }

    @Override
    public E elemento() {
        return elemento;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public BTNode<E> getRight() {
        return right;
    }

    public void setRight(BTNode<E> right) {
        this.right = right;
    }

    public BTNode<E> getLeft() {
        return left;
    }

    public void setLeft(BTNode<E> left) {
        this.left = left;
    }

    public BTNode<E> getParent() {
        return parent;
    }

    public void setParent(BTNode<E> parent) {
        this.parent = parent;
    }
}
