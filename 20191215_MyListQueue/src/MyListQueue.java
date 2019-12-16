/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 18:54
 */
class MyListQueue {
    static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public Node front;
    public Node rear;
    public int usedSize;
    public boolean isEmpty(){
        return this.usedSize == 0;
    }
    //入队
    public void offer(int data){
        Node node = new Node(data);
        if(isEmpty()){
            this.front = node;
            this.rear = node;
        }else{
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
    }
    //出队
    public int poll(){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int tmp = this.front.data;
        front = front.next;
        this.usedSize--;
        return tmp;
    }
    public int peek(){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }
}
