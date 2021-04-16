package material.tree.binarysearchtree;

import material.tree.binarysearchtree.Student;
/**
 * Created by David R on 15/06/2016.
 */
public class CompareStudent {
    public static void main (String args[]){

        Student.CompName compN = new Student.CompName();
        Student.CompAge compA = new Student.CompAge();
        Student.CompMark compM = new Student.CompMark();


        //Comparar por edad
        LinkedBinarySearchTree<Student> abb = new LinkedBinarySearchTree<>(compA);
        abb.insert(new Student("Nathan Drake", 42, 1, 9.5 ));
        abb.insert(new Student("Victor Sullivan", 57, 2, 10 ));
        abb.insert(new Student("Pedro Paramo", 50, 3, 8 ));
        abb.insert(new Student("Tyler Durden", 40, 4, 7.5 ));
        abb.insert(new Student("Tony Soprano", 58, 5, 5.3 ));
        abb.insert(new Student("Jack Sparrow", 35, 6, 6.5 ));
        abb.insert(new Student("Vincent Vega", 32, 7, 5.1 ));
        abb.insert(new Student("Jules Winnfield", 43, 8, 6.8 ));

        System.out.println("El mas joven esa: "+abb.first().getElement().getName());
        System.out.println("El mas viejo es: "+abb.last().getElement().getName());
        System.out.println("");


        LinkedBinarySearchTree<Student> abb2 = new LinkedBinarySearchTree<>(compN);
        abb2.insert(new Student("Aathan Drake", 42, 1, 9.5 ));
        abb2.insert(new Student("Victor Sullivan", 57, 2, 10 ));
        abb2.insert(new Student("Pedro Paramo", 50, 3, 8 ));
        abb2.insert(new Student("Tyler Durden", 40, 4, 7.5 ));
        abb2.insert(new Student("Zony Soprano", 58, 5, 5.3 ));
        abb2.insert(new Student("Jack Sparrow", 35, 6, 6.5 ));
        abb2.insert(new Student("Vincent Vega", 32, 7, 5.1 ));
        abb2.insert(new Student("Jules Winnfield", 43, 8, 6.8 ));

        System.out.println("El primer nombre (alfabeticamente) : "+abb2.first().getElement().getName());
        System.out.println("El ultimo nombre (alfabeticamente) : "+abb2.last().getElement().getName());
        System.out.println("");

        LinkedBinarySearchTree<Student> abb3 = new LinkedBinarySearchTree<>(compM);
        abb3.insert(new Student("Nathan Drake", 42, 1, 9.5 ));
        abb3.insert(new Student("Victor Sullivan", 57, 2, 10 ));
        abb3.insert(new Student("Pedro Paramo", 50, 3, 8 ));
        abb3.insert(new Student("Tyler Durden", 40, 4, 7.5 ));
        abb3.insert(new Student("Tony Soprano", 58, 5, 5.3 ));
        abb3.insert(new Student("Jack Sparrow", 35, 6, 6.5 ));
        abb3.insert(new Student("Vincent Vega", 32, 7, 5.1 ));
        abb3.insert(new Student("Jules Winnfield", 43, 8, 6.8 ));

        System.out.println("El que tiene menos nota: "+abb3.first().getElement().getName());
        System.out.println("El tiene mas nota: "+abb3.last().getElement().getName());
        System.out.println("");


    //Con AVL ahora
       AVLTree<StudentCompAge> avl = new AVLTree<>();
        avl.insert(new StudentCompAge("Nathan Drake", 42, 1, 9.5 ));
        avl.insert(new StudentCompAge("Victor Sullivan", 57, 2, 10 ));
        avl.insert(new StudentCompAge("Pedro Paramo", 50, 3, 8 ));
        avl.insert(new StudentCompAge("Iñigo Montoya ", 40, 4, 7.5 ));
        avl.insert(new StudentCompAge("Tony Soprano", 58, 5, 5.3 ));
        avl.insert(new StudentCompAge("Jack Sparrow", 35, 6, 6.5 ));
        avl.insert(new StudentCompAge("Vincent Vega", 32, 7, 5.1 ));
        avl.insert(new StudentCompAge("Jules Winnfield", 43, 8, 6.8 ));

        System.out.println("AVL - El mas joven esa: "+avl.first().getElement().getName());
        System.out.println("AVL - El mas viejo es: "+avl.last().getElement().getName());
        System.out.println("");


        AVLTree<StudentCompMark> avl2 = new AVLTree<>();
        avl2.insert(new StudentCompMark("Nathan Drake", 42, 1, 9.5 ));
        avl2.insert(new StudentCompMark("Victor Sullivan", 57, 2, 10 ));
        avl2.insert(new StudentCompMark("Pedro Paramo", 50, 3, 8 ));
        avl2.insert(new StudentCompMark("Iñigo Montoya ", 40, 4, 7.5 ));
        avl2.insert(new StudentCompMark("Tony Soprano", 58, 5, 5.3 ));
        avl2.insert(new StudentCompMark("Jack Sparrow", 35, 6, 6.5 ));
        avl2.insert(new StudentCompMark("Vincent Vega", 32, 7, 5.1 ));
        avl2.insert(new StudentCompMark("Jules Winnfield", 43, 8, 6.8 ));

        System.out.println("AVL - El que tiene menos nota: "+avl2.first().getElement().getName());
        System.out.println("AVL - El tiene mas nota: "+avl2.last().getElement().getName());
        System.out.println("");


        AVLTree<StudentCompName> avl3 = new AVLTree<>();
        avl3.insert(new StudentCompName("Nathan Drake", 42, 1, 9.5 ));
        avl3.insert(new StudentCompName("Victor Sullivan", 57, 2, 10 ));

        avl3.insert(new StudentCompName("Iigo Montoya ", 40, 4, 7.5 ));
        avl3.insert(new StudentCompName("Tony Soprano", 36, 5, 5.3 ));
        avl3.insert(new StudentCompName("Jack Sparrow", 35, 6, 6.5 ));
        avl3.insert(new StudentCompName("Vincent Vega", 32, 7, 5.1 ));
        avl3.insert(new StudentCompName("Jules Winnfield", 43, 8, 6.8 ));

        System.out.println("AVL -El primer nombre (alfabeticamente) : "+avl3.first().getElement().getName());
        System.out.println("AVL -El ultimo nombre (alfabeticamente) : "+avl3.last().getElement().getName());
        System.out.println("");


        //Con ARN ahora
        AVLTree<StudentCompAge> arn = new AVLTree<>();
        arn.insert(new StudentCompAge("Nathan Drake", 42, 1, 9.5 ));
        arn.insert(new StudentCompAge("Victor Sullivan", 57, 2, 10 ));
        arn.insert(new StudentCompAge("Pedro Paramo", 50, 3, 8 ));
        arn.insert(new StudentCompAge("Iñigo Montoya ", 40, 4, 7.5 ));
        arn.insert(new StudentCompAge("Tony Soprano", 58, 5, 5.3 ));
        arn.insert(new StudentCompAge("Jack Sparrow", 35, 6, 6.5 ));
        arn.insert(new StudentCompAge("Vincent Vega", 32, 7, 5.1 ));
        arn.insert(new StudentCompAge("Jules Winnfield", 43, 8, 6.8 ));

        System.out.println("ARN - El mas joven esa: "+arn.first().getElement().getName());
        System.out.println("ARN - El mas viejo es: "+arn.last().getElement().getName());
        System.out.println("");


        AVLTree<StudentCompMark> arn2 = new AVLTree<>();
        arn2.insert(new StudentCompMark("Nathan Drake", 42, 1, 9.5 ));
        arn2.insert(new StudentCompMark("Victor Sullivan", 57, 2, 10 ));
        arn2.insert(new StudentCompMark("Pedro Paramo", 50, 3, 8 ));
        arn2.insert(new StudentCompMark("Iñigo Montoya ", 40, 4, 7.5 ));
        arn2.insert(new StudentCompMark("Tony Soprano", 58, 5, 5.3 ));
        arn2.insert(new StudentCompMark("Jack Sparrow", 35, 6, 6.5 ));
        arn2.insert(new StudentCompMark("Vincent Vega", 32, 7, 5.1 ));
        arn2.insert(new StudentCompMark("Jules Winnfield", 43, 8, 6.8 ));

        System.out.println("ARN - El que tiene menos nota: "+arn2.first().getElement().getName());
        System.out.println("ARN - El tiene mas nota: "+arn2.last().getElement().getName());
        System.out.println("");


        AVLTree<StudentCompName> arn3 = new AVLTree<>();
        arn3.insert(new StudentCompName("Nathan Drake", 42, 1, 9.5 ));
        arn3.insert(new StudentCompName("Victor Sullivan", 57, 2, 10 ));

        arn3.insert(new StudentCompName("Iigo Montoya ", 40, 4, 7.5 ));
        arn3.insert(new StudentCompName("Tony Soprano", 36, 5, 5.3 ));
        arn3.insert(new StudentCompName("Jack Sparrow", 35, 6, 6.5 ));
        arn3.insert(new StudentCompName("Vincent Vega", 32, 7, 5.1 ));
        arn3.insert(new StudentCompName("Jules Winnfield", 43, 8, 6.8 ));

        System.out.println("ARN -El primer nombre (alfabeticamente) : "+arn3.first().getElement().getName());
        System.out.println("ARN -El ultimo nombre (alfabeticamente) : "+arn3.last().getElement().getName());
        System.out.println("");







    }
}
