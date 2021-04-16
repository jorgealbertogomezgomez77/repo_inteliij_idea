package material.tree.binarysearchtree;

/**
 * Created by David R on 15/06/2016.
 */

    public class StudentCompName extends Student implements Comparable<StudentCompName>{

        public StudentCompName(String name, int age, int record, double mark){
            super(name,  age,  record,  mark);
        }

        public int compareTo(StudentCompName s){
            int resultado = 0;
            if(this.name.compareTo(s.getName()) < 0){
                resultado = -1;
            }
            else if (this.name.compareTo(s.getName()) > 0){
                resultado = 1;
            }
            else {
                resultado = 0;
            }
            return resultado;
        }
}
