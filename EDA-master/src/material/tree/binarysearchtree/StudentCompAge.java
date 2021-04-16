package material.tree.binarysearchtree;

/**
 * Created by David R on 15/06/2016.
 */
public class StudentCompAge extends Student implements Comparable<StudentCompAge>{

    public StudentCompAge(String name, int age, int record, double mark){
        super(name,  age,  record,  mark);
    }

    public int compareTo(StudentCompAge s){
        int resultado = 0;
        if(this.age < s.age){
            resultado = -1;
        }
        else if (this.age > s.age){
            resultado = 1;
        }
        else{
            resultado = 0;
        }
        return resultado;
    }



}
