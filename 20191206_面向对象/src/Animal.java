/**
 * Created with IntelliJ IDEA.
 * Description: Animal 类
 * User：WeiZhaoheng
 * Date: 2019/12/6
 * Time: 18:17
 */
 class Animal {
    protected String name;
    public Animal(String name){
        this.name = name;
    }
}

class Cat extends Animal implements IRunning{
     public Cat(String name){
         super(name);
     }

    @Override
    public void run() {
        System.out.println(this.name+"正在跑");
    }
}

class Fish extends Animal implements ISwimming{
     public Fish(String name){
         super(name);
     }

    @Override
    public void swim() {
        System.out.println(this.name+"正在游泳");
    }
}

class Frog extends Animal implements IRunning,ISwimming{
     public Frog(String name){
         super(name);
     }
    @Override
    public void run() {
        System.out.println(this.name+"正在跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name+"正在游泳");
    }
}

class Duck extends Animal implements IRunning,ISwimming,IFlying{
     public Duck(String name){
         super(name);
     }
    @Override
    public void fly() {
        System.out.println(this.name+"正在飞");
    }
    @Override
    public void run() {
        System.out.println(this.name+"正在跑");
    }
    @Override
    public void swim() {
        System.out.println(this.name+"正在游泳");
    }
}