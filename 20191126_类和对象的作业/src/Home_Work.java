import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * 1.编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘
 *   除四种运算.
 * 2.设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。
 *
 * 3.实现交换两个变量的值。要求：需要交换实参的值。
 * User：WeiZhaoheng
 * Date: 2019/11/26
 * Time: 20:38
 */

/**
 * 1.编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘
 *   除四种运算.
 */
class Calculator{

    private double num1;
    private double num2;

    public Calculator(){
        this.num1 = 18.9;
        this.num2 = 3;
    }
    public void sum(){
        System.out.println("num1 + num2 = " + (num1+num2));
    }
    public void sub(){
        System.out.println("num1 - num2 = "+(num1 - num2));
    }
    public void mul(){
        System.out.println("num1 * num2 = "+(num1*num2));
    }
    public void mod(){
        System.out.println("num1 / num2 = "+(num1/num2));
    }

}

//2.设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。

class Person{
    private String name;
    private String sex;
    private int age;
    private double hight;
    private double wight;

    public Person(String name,String sex){
        this.name = name;
        this.sex = sex;

    }

    public Person(int age,double hight,double wight ){
        this.age = age;
        this.hight  = hight;
        this.wight = wight;
    }

    public void name_sex(){
        System.out.println("名字是：" + name+"||"+"性别是："+ sex);

    }
    public void a_h_w(){
        System.out.println("年龄是："+age+"||"+"身高是："+ hight+"||"+ "体重是："+wight);
    }

}

//实现交换两个变量的值。要求：需要交换实参的值。

class Exchange{
    private int a;
    private int b;
    public void exchange(int a,int b){
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a:"+a+"b:"+b);
    }
}

public class Home_Work {

    public static void main(String[] args) {
        Exchange one = new Exchange();
        one.exchange(10,20);
    }


    public static void main2(String[] args) {
        Person person1 = new Person("小红","男");
        Person person2 = new Person(21,175.5,85.8);
        person1.name_sex();
        person2.a_h_w();

    }


    public static void main1(String[] args) {
        Calculator calculator =  new Calculator();
        calculator.sum();
        calculator.sub();
        calculator.mul();
        calculator.mod();
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个数的值");
        calculator.num1 = sc.nextDouble();
        calculator.num2 = sc.nextDouble();
        calculator.sum();
        calculator.sub();
        calculator.mul();
        calculator.mod();
        */

    }
}
