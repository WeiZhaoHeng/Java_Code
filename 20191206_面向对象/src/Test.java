import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/6
 * Time: 17:23
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.name = "白给";
        Person person1 = (Person)person.clone();
        System.out.println(person.name+" "+person.m.money);
        System.out.println(person1.name+" "+person1.m.money);
        System.out.println("================================");
        person1.name = "蛋蛋蛋";
        person1.m.money = 11.52;
        System.out.println(person.name+" "+person.m.money);
        System.out.println(person1.name+" "+person1.m.money);

    }
    public static void main2(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("小明",15,86.5);
        students[1] = new Student("小白",17,83.5);
        students[2] = new Student("小黑",10,81.5);
        students[3] = new Student("小蓝",20,89.5);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void behaviro(IRunning run){
        System.out.println("一会儿：");
        run.run();
    }

    public static void main1(String[] args) {
        Cat animal1 = new Cat("小猫");
        Fish animal2 = new Fish("小鱼");
        Frog animal3 = new Frog("青蛙");
        Duck animal4 = new Duck ("鸭子");
        Animal[] animals = {animal1,animal2,animal3,animal4};
        for (Animal X:animals) {
            System.out.println(X.name);
        }
        behaviro(animal1);
        behaviro(animal3);
        behaviro(animal4);
    }
}
