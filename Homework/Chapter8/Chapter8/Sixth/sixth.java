package Homework.Chapter8.Sixth;

public class sixth {
    public static void main(String[] args) {
        new Demo().test();//注意这里：这是先调用构造器，然后再调用方法的，要特别注意呀
        new Demo("john").test();
    }
}

class Test{
    String name = "Rose";
    Test(){
        System.out.println("Test");
    }
    Test(String name){
        this.name = name;
    }
}

class Demo extends Test{
    String name = "Jack";
    Demo(){
        super();
        System.out.println("Demo");
    }
    Demo(String s){
        super(s);
    }
    public void test(){
        System.out.println(super.name);
        System.out.println(this.name);
    }
}