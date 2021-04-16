package TreeStructure.LinkedTree;

import TreeStructure.Tree.Position;

import java.util.List;

public class TreeNode<E> implements Position<E> {
    private TreeNode<E> padre;
    private E elemento;
    private List<TreeNode<E>> hijos;

    public TreeNode(TreeNode<E> padre, E elemento, List<TreeNode<E>> hijos) {
        this.padre = padre;
        this.elemento = elemento;
        this.hijos = hijos;
    }

    @Override
    public E elemento() {
        return elemento;
    }

    public TreeNode<E> getPadre() {
        return padre;
    }

    public void setPadre(TreeNode<E> padre) {
        this.padre = padre;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public List<TreeNode<E>> getHijos() {
        return hijos;
    }

    public void setHijos(List<TreeNode<E>> hijos) {
        this.hijos = hijos;
    }
}
