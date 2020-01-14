/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 13:39
 */
class Node<T>{
    public T val;
    public Node next;
    public Node(T val) {
        this.val = val;
    }
}
class MySingleStack <T>{
    public Node head;
    public MySingleStack() {
        this.head = null;
    }
    private void addFirst(T val){
        Node<T> node = new Node<>(val);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    public void push(T val){
        addFirst(val);
    }

    public void pop(){
        if(this.head == null){
            return;
        }
        this.head = this.head.next;
    }
    public T gettop(){
        if(this.head == null){
            return null;
        }
        return (T)this.head.val;
    }
}
