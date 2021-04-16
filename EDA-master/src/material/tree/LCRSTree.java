package material.tree;

import material.tree.iterator.BFSIteratorFactory;
import java.util.*;
import material.tree.iterator.TreeIteratorFactory;

/**
 * A linked class for a tree where nodes have an arbitrary number of children.
 *
 * @author Raul Cabido, Abraham Duarte, Jose Velez, Jesús Sánchez-Oro
 * @param <E> the elements stored in the tree
 */
public class LCRSTree<E> implements Tree<E> {
    
    public class TreeNode<T>  implements Position<T> {

        private T element;
        private TreeNode<T> parent; // nodo padre
        private TreeNode<T> sibling; //nodo siguiente hermano (derecho)
        private TreeNode<T> child; //Nodo primer hijo hijo (izquierdo)
        private LCRSTree<T> myTree; //referencia al arbol al que pertenecen los nodos


        /*constructor de la clase TreeNode

         */
        public TreeNode (LCRSTree<T> t, T e, TreeNode<T> p, TreeNode<T> s, TreeNode<T> c ){

            this.myTree = t;
            this.element = e;
            this.parent= p;
            this.sibling = s;
            this.child = c;
        }

        @Override
        public T getElement() {
            return element;
        }

        public final void setElement(T o) {
            element = o;
        }
        public TreeNode<T> getParent(){
            return parent;
        }
        public void setParent(TreeNode<T> parent) {

            this.parent = parent;
        }

        public TreeNode<T> getSibling(){

            return sibling;
        }
        public void setSibling(TreeNode<T> sibling){
            this.sibling = sibling;
        }

        public TreeNode<T> getChild(){
            return child;
        }
        public void setChild(TreeNode<T> child){
            this.child = child;
        }

        public LCRSTree<T> getMyTree(){
            return myTree;
        }
        public void setMyTree(LCRSTree<T> myTree){
            this.myTree = myTree;
        }
    }

    //atributos del arbol
    private TreeNode<E> root; // raiz del arbol
    private int size; // numero de nodos en el arbol
    private TreeIteratorFactory<E> iteratorFactory; // fabrica de iteradores

    //constructor del arbol
    public LCRSTree() {
        root = null;
        size = 0;
        this.iteratorFactory = new BFSIteratorFactory<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean isInternal(Position<E> v) throws IllegalStateException {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> p) throws IllegalStateException {
        TreeNode <E> node  = checkPosition(p);
        return node.getChild() == null; // si no tiene hijo izquierdo no tiene nigun hijo
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        return node == this.root;
        //return node.getParent() == null;// no vale??

    }

    @Override
    public Position<E> root() throws IllegalStateException {
        if (root == null){
            throw new IllegalStateException("The tree is empty");
        }
        return root;

    }

    @Override
    public Position<E> parent(Position<E> p) throws IndexOutOfBoundsException,
            IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        //Position<E> parentPos = (Position<E>) node.getParent();
        Position<E> parentPos = node.getParent(); //segun IDEA no hace falta casting, pero el profelo hace en linkedTree
        if (parentPos == null) {
            throw new IndexOutOfBoundsException("The node has not parent");
        }
        return parentPos;

    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        List<Position<E>> children = new ArrayList<>();

        if(isLeaf(p)){
            //Los nodos hojas no tienen hijos, ¿tratar con una excepcion o devolver lista vacia?
        }

        TreeNode<E> posChild = node.getChild();

        while (posChild != null){
            children.add(posChild);
            posChild = posChild.getSibling();
        }

        return children;
    }

    public E replace(Position<E> p, E e) throws IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        E prevValue = node.getElement();
        node.setElement(e);

        return prevValue;

    }

    @Override
    public Position<E> addRoot(E e) throws IllegalStateException {
        if(!isEmpty()){
            throw new IllegalStateException("El arbol no está vacio, no se puede añadir una raiz");
        }
        size =1;
        //TreeNode<E> root = new TreeNode<>(this,e, null, null, null);
        root = new TreeNode<>(this,e, null, null, null);
        return root;
    }

    public void swapElements(Position<E> p1, Position<E> p2)
            throws IllegalStateException {
        TreeNode<E> nodo1 = checkPosition(p1);
        TreeNode<E> nodo2 = checkPosition(p2);

        E temp1 = nodo1.getElement();
        E temp2 = nodo2.getElement();

        nodo2.setElement(temp1);
        nodo1.setElement(temp2);

    }

    private TreeNode<E> checkPosition(Position<E> p)
            throws IllegalStateException {
        if(p == null || !(p instanceof TreeNode)){
            throw new IllegalStateException("No es un Position valido");
        }
        TreeNode<E> aux =(TreeNode<E>) p;

        if (aux.getMyTree() != this) {
            throw new IllegalStateException("El nodo no es de este arbol");
        }
        return aux;
    }

    public Position<E> add(E element, Position<E> p) throws IllegalStateException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TreeNode<E> nodo =  checkPosition(p);
        TreeNode<E> nuevoHijo = nodo.getChild();

        if (nodo.getChild() == null){
            nuevoHijo = new TreeNode<>(this,element, nodo,null, null);
            nodo.setChild(nuevoHijo);
        }
        else{
            nuevoHijo = new TreeNode<>(this,element, nodo,null, null);
            TreeNode<E> aux = nodo.getChild();
            while (aux.getSibling() != null){
                aux = aux.getSibling();
            }
            aux.setSibling(nuevoHijo);
        }
        size++;
        return nuevoHijo;

    }

    public void remove(Position<E> p) throws IllegalStateException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TreeNode<E> node = this.checkPosition(p);
        if (node.getParent() != null) { //si no es la raiz
            Iterator<Position<E>> it = this.iteratorFactory.createIterator(this, p);
            int cont = 0;
            while (it.hasNext()) {
                it.next();
                cont++;
            }
            size -= cont; //es igual a --> size = size - cont;

            TreeNode<E> parent = node.getParent();
            TreeNode<E> child = parent.getChild();
            if (child == node) { //si es el primer hijo izdo
                parent.setChild(child.getSibling());//El hijo del nodo a borrar pasa a ser el hijo del padre
            } else {
                while(child.getSibling() != node){//mentras tenga hermanos distintos al nodo a borrar
                    child = child.getSibling(); //me muevo al siguiente hermano
                }
                TreeNode<E> child2 = node.getSibling(); //nuevo nodo para puentear. child2 es el siguiente hermano.
                child.setSibling(child2); //Se sobreescribe con el siguiente hermano derecho, saltandose asi el nodoa borar
            }
        } else {
            this.root = null;
            this.size = 0;
        }
        node.setMyTree(null); //quito la referencia al arbol
    }

    public void setIterator(TreeIteratorFactory<E> iteratorFactory) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.iteratorFactory = iteratorFactory;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.iteratorFactory.createIterator(this);

    }

    public Position<E> moveSubtree(Position<E> pOrig, Position<E> pDest) throws IllegalStateException {
        TreeNode<E> nodeOrig = checkPosition(pOrig);
        TreeNode<E> nodeDest = checkPosition(pDest);
        TreeNode<E> padreOrig = nodeOrig.getParent();

        if (nodeOrig == this.root) {
            throw new IllegalStateException("el origen no puede ser la raiz");
        } else {
            Iterator<Position<E>> it = this.iteratorFactory.createIterator(this, nodeOrig);
            while (it.hasNext()) { //Vamos a ver que destino no este contenido en origen
                if (it.next() == nodeDest) {
                    throw new IllegalStateException("destino no puede ser hijo de origen");
                }
            }

            nodeOrig.setParent(nodeDest);//Ponemos al nodo origen como hijo del nodo destino
            //Borramos del padre del position origen, su hijo=pOrig
            TreeNode child = padreOrig.getChild();
            if (child == nodeOrig) {
                padreOrig.setChild(child.getSibling());
            } else {
                while (child.getSibling() != nodeOrig) {
                    child = child.getSibling();
                }
                TreeNode<E> child2 = nodeOrig.getSibling();
                child.setSibling(child2);// ponemos puenteamos el hemano izquierdo y el derecho del nodo origen.
            }
            nodeOrig.setSibling(null);//Dejamos que el nodo origen apunte a sus antiguos hermanos, si los hay
            //Añadimos el nodoOrig como último hijo del nodoDest
            TreeNode<E> childDest = nodeDest.getChild();
            if (childDest != null) {//Si el nodo destino tiene al menos un hijo
                while (childDest.getSibling() != null) {
                    childDest = childDest.getSibling();
                }
                childDest.setSibling(nodeOrig);
            } else {//Si no tiene el nodoDest ningún hijo
                nodeDest.setChild(nodeOrig);
            }
        }
        return pDest;

    }

}
