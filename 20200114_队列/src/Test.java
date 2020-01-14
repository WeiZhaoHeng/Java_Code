import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 13:16
 */
public class Test {
    public static void main4(String[] args) {
        MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<>(10);
        myArrayQueue.enQueue(10);
        myArrayQueue.enQueue(11);
        myArrayQueue.enQueue(12);
        myArrayQueue.enQueue(13);
        myArrayQueue.enQueue(14);
        System.out.println(myArrayQueue.getFront());
        System.out.println(myArrayQueue.getRear());
        myArrayQueue.deQueue();
        System.out.println(myArrayQueue.getFront());
        System.out.println(myArrayQueue.getRear());

    }
    public static void main3(String[] args) {
        MySingleQueue<String> mySingleQueue = new MySingleQueue<>();
        mySingleQueue.push("a");
        mySingleQueue.push("b");
        mySingleQueue.push("c");
        mySingleQueue.push("d");
        mySingleQueue.push("e");
        System.out.println(mySingleQueue.get());
        System.out.println(mySingleQueue.pop());
        System.out.println(mySingleQueue.get());
    }
    public static void main2(String[] args) {
        MySingleStack<Integer> mySingleStack = new MySingleStack<>();
        mySingleStack.push(10);
        mySingleStack.push(20);
        mySingleStack.push(30);
        mySingleStack.push(40);
        System.out.println(mySingleStack.gettop());
        mySingleStack.pop();
        System.out.println(mySingleStack.gettop());
    }
    public static void main1(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        System.out.println(myStack.pop());
        System.out.println(myStack.get());
    }
}
