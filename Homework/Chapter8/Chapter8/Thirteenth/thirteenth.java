package Homework.Chapter8.Thirteenth;

import java.sql.SQLOutput;

public class thirteenth {
    public static void main(String[] args) {
        Person[] persons = new Person[]{
                new Teacher("张飞",'男',30,5),
                new Teacher("关羽",'男',56,5),
                new Student("刘禅",'男',16,32),
                new Student("小明",'男',15,21)
        };
        Bubble_sort(persons);
        for(int i = 0; i < persons.length ; i++){
            System.out.println("--------------------------");
            persons[i].printlnfo();
        }
    }
    public static Person[] Bubble_sort(Person... persons){
        for (int i = 0; i < persons.length; i++) {
            for(int j = 0; j < persons.length - i - 1; j++)
                if(persons[j].getAge() < persons[j+1].getAge()){
                    Person temp = null;
                    temp = persons[j];
                    persons[j] = persons[j+1];
                    persons[j+1] = temp;
                }
        }
        return persons;
    }
}
class Person{
    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String play(){
        return name + "爱玩";
    }
    public void printlnfo(){
        System.out.println("姓名：" + name + "\n" + "年龄:" + age + "\n" + "性别：" + sex);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
class Student extends Person{
    private int stu_id;

    public Student(String name, char sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }
    public void study(){
        System.out.println("我承诺,我会好好学习");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    @Override
    public void printlnfo() {
        System.out.println("学生的信息:");
        super.printlnfo();
        System.out.println("学号：" + stu_id);
        this.study();
        System.out.println(play());
    }
}
class Teacher extends Person{
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }
    public void teach(){
        System.out.println("我承诺，我会认真教学。");
    }
    public String play(){
        return super.play() + "象棋";
    }

    @Override
    public void printlnfo() {
        System.out.println("老师的信息：");
        super.printlnfo();
        System.out.println("工龄：" + work_age);
        this.teach();
        System.out.println(play());
    }
}