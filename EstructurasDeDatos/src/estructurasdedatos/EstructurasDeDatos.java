package estructurasdedatos;

import Cola.QueueDoble;
import Lista.DoubleLinkedList;
import Pila.Pila;

public class EstructurasDeDatos {
    public static void main(String[] args) {
        /*Pila p = new Pila();
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";

        p.Push(s1);
        String resultado = (String) p.Top();
        System.out.println(resultado);
        p.Push(s2);
        resultado = (String) p.Top();
        System.out.println(resultado);
        p.Push(s3);
        resultado = (String) p.Top();
        System.out.println(resultado);
        p.Pop();
        resultado = (String) p.Top();
        System.out.println(resultado);
        p.Pop();
        resultado = (String) p.Top();
        System.out.println(resultado);
        p.Pop();
        resultado = (String) p.Top();
        System.out.println(resultado);
        p.Pop();*/




        /*QueueDoble c = new QueueDoble();
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        c.EnQueue(s1);
        c.EnQueue(s2);
        c.EnQueue(s3);
        c.DeQueue();
        c.DeQueue();
        c.DeQueue();
        System.out.println((String) c.Front());*/


        DoubleLinkedList<String> dl = new DoubleLinkedList<String>();
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        String s4 = "4";
        dl.addLast(s1);
        dl.addLast(s2);
        dl.addLast(s3);
        dl.addLast(s4);
        String s5 = "Hola soy el nuevo";
        dl.add(s5, 2);
        String resultado = "";


        //dl.remove(3);

        DoubleLinkedList<String> dl2 = new DoubleLinkedList<String>();
        while (dl.isEmpty() == false) {
            System.out.println(dl.getFirst());
            dl2.addFirst(dl.getFirst());
            dl.removeFirst();
        }
        dl = dl2;

        System.out.println("-----------------------------------");
        System.out.println((String) dl.get(1));
    }
}
