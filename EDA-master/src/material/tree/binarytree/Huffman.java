package material.tree.binarytree;

import material.tree.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by David R on 13/06/2016.
 */
public class Huffman {

    private class HuffmanNode {
        private char character;
        private int frecuency;
        private String code = "";


        public HuffmanNode(char c) {
            this.character = c;
            this.frecuency = 1;


        }

        public int getFrecuency() {
            return frecuency;
        }

        public void setFrecuency(int frecuency) {
            this.frecuency = frecuency;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

    }


    ArrayList<HuffmanNode> almacen = new ArrayList<>();
    ArrayList<LinkedBinaryTree<HuffmanNode>> bosque = new ArrayList<>();

    public Huffman(String sentence) {

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            HuffmanNode caracter = findHuffmanNode(c);
            if (caracter == null) {
                caracter = new HuffmanNode(c);
                almacen.add(caracter);
            } else {
                caracter.setFrecuency(caracter.getFrecuency() + 1);
            }
        }
        System.out.println("El numero de caracteres distintos es: " + almacen.size());
        for (HuffmanNode c : almacen) {//creamos arboles que solo tengan la raiz, que son cada nodoHuffman()caracter, frecuencia.
            LinkedBinaryTree<HuffmanNode> arbol = new LinkedBinaryTree<>();
            arbol.addRoot(c);
            bosque.add(arbol);
        }
        System.out.println("Size: " + bosque.size());

        while (1 < bosque.size()) {
            LinkedBinaryTree<HuffmanNode> menor1 = dameMenor();
            LinkedBinaryTree<HuffmanNode> menor2 = dameMenor();
            LinkedBinaryTree<HuffmanNode> nuevoArbol = new LinkedBinaryTree<HuffmanNode>();

            HuffmanNode nuevoNodo = new HuffmanNode('$');
            nuevoNodo.setFrecuency(menor1.root().getElement().getFrecuency() + menor2.root().getElement().getFrecuency());
            //añadimos el nodo a la raiz del nuevo arbol
            Position<HuffmanNode> raiz = nuevoArbol.addRoot(nuevoNodo);
            Position<HuffmanNode> raizIzq = nuevoArbol.insertLeft(raiz, menor1.root().getElement());
            Position<HuffmanNode> raizDer = nuevoArbol.insertRight(raiz, menor2.root().getElement());

            copiarArbol(nuevoArbol, raizIzq, menor1, menor1.root());
            copiarArbol(nuevoArbol, raizDer, menor2, menor2.root());

            bosque.add(nuevoArbol);

        }

        analisis(bosque.get(0), bosque.get(0).root(), "");
        for (HuffmanNode c : almacen) {
            System.out.println("La letra: " + c.getCharacter() + " tiene un codigo Huffman: " + c.getCode());
        }


    }

    public void copiarArbol(LinkedBinaryTree<HuffmanNode> destino, Position<HuffmanNode> raizDestino, LinkedBinaryTree<HuffmanNode> origen, Position<HuffmanNode> raizOrigen) {
        if (origen.hasRight(raizOrigen)) {
            Position<HuffmanNode> derecha = destino.insertRight(raizDestino, origen.right(raizOrigen).getElement());

            copiarArbol(destino, derecha, origen, origen.right(raizOrigen));
        }
        if (origen.hasLeft(raizOrigen)) {
            Position<HuffmanNode> izquierda = destino.insertLeft(raizDestino, origen.left(raizOrigen).getElement());
            copiarArbol(destino, izquierda, origen, origen.left(raizOrigen));
        }

    }

    public void analisis(LinkedBinaryTree<HuffmanNode> arbol, Position<HuffmanNode> p, String code) {
        if (arbol.isLeaf(p)) {
            p.getElement().setCode(code);
        } else {
            analisis(arbol, arbol.left(p), code + "0");
            analisis(arbol, arbol.right(p), code + "1");
        }
    }

    public HuffmanNode findHuffmanNode(char character) {
        for (HuffmanNode c : almacen) {
            if (c.getCharacter() == character) {
                return c;
            }
        }
        return null;
    }

    public LinkedBinaryTree<HuffmanNode> dameMenor() {
        LinkedBinaryTree<HuffmanNode> menor = null;
        for (LinkedBinaryTree<HuffmanNode> c : bosque) {
            if (menor == null) {
                menor = c;
            } else if (menor.root().getElement().getFrecuency() > c.root().getElement().getFrecuency()) {
                menor = c;
            }
        }
        bosque.remove(menor);
        return menor;
    }

    public static void main(String[] args) throws IOException, NoSuchFieldException {


        Scanner teclado = new Scanner(System.in);
        String opcion = "";

       do {
            System.out.println("Introduce una cadena de texo y se te devovera la codificacion huffman correspondiente");
            System.out.println("Para salir del programa escribe: EXIT");
            opcion = teclado.nextLine();
           if(!opcion.equals("EXIT")){
               Huffman huffman = new Huffman(opcion);
           }

        } while (!opcion.equals("EXIT"));

        System.out.println("Saliendo del programa...");

    }
}