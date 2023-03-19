package Homework.Chapter8.Eleventh;

public class eleventh {
    public static void main(String[] args) {
        Person person = new Student();
        person.eat();
        person.run();
        //这里要注意一下
        System.out.println("===================================");
        Student student = (Student) person;
        student.eat();
        student.run();
        student.study();
        //student.run(); student.eat();student.study
    }
}
class Person{
    public void run(){
        System.out.println("person run");
    }
    public void eat(){
        System.out.println("person eat");
    }
}
class Student extends Person{
    public void run(){
        System.out.println("student run");
    }
    public void study(){
        System.out.println("student study...");
    }
}
