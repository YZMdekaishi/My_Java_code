package Homework.Chapter8.fifth;

public class fifth {
    public static void main(String[] args) {
        Scientist scientist = new Scientist(100);
        scientist.setBonus(200);
        System.out.println(scientist.salInf());
    }
}

class Employee{
    private double sal;

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Employee(double sal) {
        this.sal = sal;
    }
    public double salInf(){
        return sal;
    }
}
class Worker extends Employee{
    public Worker(double sal) {
        super(sal);
    }

    @Override
    public double salInf() {
        return super.salInf();
    }
}
class Teacher extends Employee{
    private double classSal;
    private int classDay;

    public Teacher(double sal, double classSal, int classDay) {
        super(sal);
        this.classSal = classSal;
        this.classDay = classDay;
    }

    @Override
    public double salInf() {
        return super.salInf() + classSal * classDay;
    }
}
class Scientist extends Employee{
    private double bonus;

    public Scientist(double sal) {
        super(sal);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double salInf() {
        return super.salInf() + bonus;
    }
}