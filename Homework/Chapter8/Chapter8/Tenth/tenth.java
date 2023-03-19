package Homework.Chapter8.Tenth;

public class tenth {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("jack", 18, "上学", '男', 0);
        Doctor doctor2 = new Doctor("jack", 1, "上学", '男', 0);
        System.out.println(doctor.equals(doctor2));
    }
}
class Doctor{
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if (!(obj instanceof  Doctor)){
            return false;
        }
        Doctor doctor = (Doctor) obj;
        return doctor.name.equals(this.name) && doctor.age == this.age
                && doctor.job.equals(this.job) && doctor.gender == this.gender && doctor.sal == this.sal;
    }
}
