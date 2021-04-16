package material.tree.binarysearchtree;

/**
 * Created by David R on 15/06/2016.
 */

public class StudentCompMark extends Student implements Comparable<StudentCompMark>{

        public StudentCompMark(String name, int age, int record, double mark){
            super(name,  age,  record,  mark);
        }

        public int compareTo(StudentCompMark s){
            int resultado = 0;
            if(this.mark < s.mark){
                resultado = -1;
            }
            else if (this.mark > s.mark){
                resultado = 1;
            }
            else{
                resultado = 0;
            }
            return resultado;
        }

}
