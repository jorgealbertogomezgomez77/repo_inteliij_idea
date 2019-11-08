// I have a error...
package Aplicaciones;

import LinkedBinaryTree.LinkedBinaryTree;
import LinkedBinaryTree.Position;
import java.util.Scanner;

public class Adivinator {

    static LinkedBinaryTree<String> a = new LinkedBinaryTree<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena1 = "";
        String cadena2 = "";
        System.out.println("¿De qué tema quieres que te adivine?");
        cadena1 = sc.nextLine();
        a.addRoot(cadena1);
        System.out.println("Dame un ejemplo de un " + a.root().elemento());
        cadena1 = sc.nextLine();
        a.addLeft(a.root(), cadena1);
        while (cadena2.compareToIgnoreCase("fin") != 0) {

        } // Fin de while.
    } // Fin del metodo main.

    public static void recorreArbol(Position<String> p) {
        Scanner sc = new Scanner(System.in);
        String res1 = "";
        if (a.isLeaf(p)) {
            System.out.println(p.elemento() + "?");
            res1 = sc.nextLine();
            if (res1.compareToIgnoreCase("si") == 0) {
                System.out.println("Bien he acertado!!! volvemos a empezar.");
                Adivinator.recorreArbol(a.root());
            }
            else {
                System.out.println("Vaya, nunca lo habría adivinado.");
                System.out.println("Pos favor, escribeme la solución.");
                String solución = sc.nextLine();
                System.out.println("Escribeme lo que diferencia. " + solución + " y " + p.elemento());
                String nodointerno = sc.nextLine();
                String oldleaf = p.elemento();
                a.replace(p, nodointerno);
                a.addLeft(p, solución);
                a.addRight(p, oldleaf);
                System.out.println("Vamos a empezar.");
                Adivinator.recorreArbol(a.root());
            }
        } // En caso de que el nodo sea hoja.
        else {
            System.out.println(p.elemento() + "?");
            res1 = sc.nextLine();
            if (res1.compareToIgnoreCase("si") == 0) {
                if (a.hasLeft(p)) {
                    Adivinator.recorreArbol(a.left(p));
                }
                else {
                    System.out.println("¿En qué estabas pensando?.");
                    String res2 = sc.nextLine();
                    a.addLeft(p, res2);
                    System.out.println("Volvemos a empezar.");
                    Adivinator.recorreArbol(a.root());
                }
            }
            else {
                if (a.hasRight(p)) {
                    Adivinator.recorreArbol(a.right(p));
                }
                else {
                    System.out.println("¿En qué estabas pensando?.");
                    String res2 = sc.nextLine();
                    a.addRight(p, res2);
                    System.out.println("Volvemos a empezar.");
                    Adivinator.recorreArbol(a.root());
                }
            }
        }
    }
}
