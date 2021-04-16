package material.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

import material.tree.Position;
import material.tree.binarytree.LinkedBinaryTree.BTNode;

public class BinaryTreeUtils<E> {

    private BinaryTree<E> binTree;
    
    public BinaryTreeUtils(BinaryTree<E> binTree) {

        this.binTree = binTree;
    }

    /**
     * Given a tree the method returns a new tree where all left children become
     * right children and vice versa
     * @return the mirror of the tree
     */
    public BinaryTree<E> mirror() throws IllegalStateException, IndexOutOfBoundsException {
            BinaryTree<E> sol = null;
            if (this.binTree instanceof LinkedBinaryTree) {
                Position<E> raiz = this.binTree.root();
                LinkedBinaryTree<E> treeMirror = new LinkedBinaryTree<>();
                treeMirror.addRoot(raiz.getElement());
                mirrorAux(treeMirror, raiz, treeMirror.root());
                sol = (BinaryTree<E>) treeMirror;
            }
            else if(this.binTree instanceof ArrayBinaryTree) {
                Position<E> raiz = this.binTree.root();
                ArrayBinaryTree<E> treeMirror = new ArrayBinaryTree<>(100);
                treeMirror.addRoot(raiz.getElement());
                mirrorAux(treeMirror, raiz, treeMirror.root());
                sol = (BinaryTree<E>) treeMirror;
            }
            return sol;
        }

    private void mirrorAux(BinaryTree<E> treeMirror, Position<E> raiz, Position<E> mirrorRoot){
        if(this.binTree.hasLeft(raiz)){
            treeMirror.insertRight(mirrorRoot, this.binTree.left(raiz).getElement());
        }
        if(this.binTree.hasRight(raiz)){
            treeMirror.insertLeft(mirrorRoot, this.binTree.right(raiz).getElement());
        }
        if(!this.binTree.isLeaf(raiz)){
            if(this.binTree.hasLeft(raiz))
                mirrorAux(treeMirror, this.binTree.left(raiz), treeMirror.right(mirrorRoot));
            if(this.binTree.hasRight(raiz))
                mirrorAux(treeMirror, this.binTree.right(raiz), treeMirror.left(mirrorRoot));
        }
    }

    /**
     * Determines whether the element e is the tree or not
     * @param e the element to check
     * @return TRUE if e is in the tree, FALSE otherwise
     */
    public boolean contains(E e) {
        if(!binTree.isEmpty()){
            if(this.binTree.root().getElement() == e){
                return true;
            } else{
                //Se busca en los elementos del árbol
                boolean find = false;
                Iterator it = binTree.iterator();
                while (it.hasNext() && !find) {
                    Position<E> node = (Position<E>) it.next();
                    if (node.getElement().equals(e)) {
                        find = true;
                    }
                }
                return find;
            }
        }
        return false;
    }

    /**
     * Determines the level of a node in the tree
     * @param p the position to check
     * @return the level of the position in the tree
     */
    public int level(Position<E> p) {
        int level = 1;  //La raiz va a estar en el nivel 1 por lo que se inicializa a ese valor
        Position<E> raiz = this.binTree.root();
        if (raiz.equals(p)) {  //Si el position es la raiz, nivel del position es 1
            level = 1;
        } else {
            while (p != null) { //Vamos subiendo en el arbol mediante parent y sumandole 1 a level hasta que me devuelva null
                try {
                    p = this.binTree.parent(p); //Sacamos el padre de p, es decir, vamos subiendo en el arbol
                    level++;
                } catch (Exception e) {
                    return level;
                }
            }
        }
        return level;
    }
}
