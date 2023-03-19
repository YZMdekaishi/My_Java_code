package Homework.Chapter8.First;

public class first {
    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("jack",23,"Java工程师");
        persons[1] = new Person("milan",56,"大数据工程师");
        persons[2] = new Person("dage",14,"PHP工程师");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
        System.out.println("=============================");
        for (int i = 0; i < solution(persons).length; i++) {
            System.out.println(persons[i]);
        }
    }
    public static Person[] solution(Person... persons){
        Person temp = null;
        for (int i = 0; i < persons.length-1; i++) {
            for(int j = 0; j < persons.length-i-1; j++)
                //如果要按照名字的长度进行从大到小的排序
                //persons[j].getName().length() < persons[j+1].getName().length()
            if(persons[j].getName().length() < persons[j+1].getName().length()){
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
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}