/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 14:01
 */
class queueNode<T>{
    public T val;
    public queueNode next;
    public queueNode(T val) {
        this.val = val;
    }
}
public class MySingleQueue<T> {
    public queueNode head;
    public queueNode end;

    public MySingleQueue() {
        this.head = null;
        this.end = null;
    }

    public void push(T val){
        queueNode<T> node = new queueNode<>(val);
        if(this.head == null){
            this.head = node;
            this.end = node;
        }else{
            this.end.next = node;
            this.end = node;
        }
    }

    public T pop(){
        if(this.head == null){
            return null;
        }
        queueNode tmp = this.head;
        this.head = this.head.next;

        return (T)tmp.val;
    }

    public T get(){
        if(this.head == null){
            return null;
        }
        return (T)this.head.val;
    }
}
