import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 18:20
 */
class ListNode<T>{
    public T data;
    public ListNode next;
    public ListNode(T data){
        this.data = data;
        this.next = null;
    }
}
class MyStack2<T> {
    public ListNode head;
    public MyStack2(){
        this.head = null;
    }
    public void push(T data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }

    }
    public T pop(){
        T tmp = (T)this.head.data;
        this.head = this.head.next;
        return tmp;
    }

    public T getPop(){
        T tmp = (T)this.head.data;
        return tmp;
    }

}
