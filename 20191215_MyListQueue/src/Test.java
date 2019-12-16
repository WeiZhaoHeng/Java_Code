import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 18:54
 */
public class Test {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(5);
        myCircularQueue.enQueue(12);
        myCircularQueue.enQueue(14);
        myCircularQueue.enQueue(15);
        myCircularQueue.enQueue(16);
        myCircularQueue.enQueue(17);
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());

    }
    public static void main1(String[] args) {
        MyListQueue myListQueue = new MyListQueue();
        myListQueue.offer(12);
        myListQueue.offer(13);
        myListQueue.offer(14);
        myListQueue.offer(15);
        System.out.println(myListQueue.poll());
        System.out.println(myListQueue.peek());

    }
}
