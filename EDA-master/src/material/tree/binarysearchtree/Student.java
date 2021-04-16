package material.tree.binarysearchtree;

import java.util.Comparator;

/**
 * Created by David R on 15/06/2016.
 */
public class Student {
    String name; // name and surname
    int age; // age of the student
    int record; // record number in the university
    double mark; // average qualification in the university
    //Comparator<Student> comp;

    public Student(String name, int age, int record, double mark/*, Comparator<Student> cst*/) {
        this.name = name;
        this.age = age;
        this.record = record;
        this.mark = mark;

    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "name = " + name + ", age = " + age + ", record = " + record + ", mark = " + mark + '}';
    }
    public static class CompName implements Comparator<Student> {

        @Override
        public int compare(Student alumno1, Student alumno2) {
            return alumno1.name.compareTo(alumno2.getName());
        }

    }

    public static class CompAge implements Comparator<Student> {

        @Override
        public int compare(Student alumno1, Student alumno2) {
            if (alumno1.getAge() == alumno2.getAge()) {
                return 0;
            } else if (alumno1.getAge() < alumno2.getAge()) {
                return -1;
            } else {
                return +1;
            }
        }

    }

    public static class CompMark implements Comparator<Student> {

        @Override
        public int compare(Student alumno1, Student alumno2) {
            if (alumno1.getMark() == alumno2.getMark()) {
                return 0;
            } else if (alumno1.getMark() < alumno2.getMark()) {
                return -1;
            } else //Caso de que st tenga mayor nota que st1
            {
                return +1;
            }
        }

    }

}
