/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 19:27
 */
public class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear;
    public int usedSize;

    public MyCircularQueue(int k){
        this.elem = new int[k+1];
        this.front = 0;
        this.rear = 0;
        this.usedSize = 0;
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }

    public boolean isFull(){
        return (this.rear+1) % this.elem.length == this.front;
    }

    public boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear+1)%this.elem.length;
        this.usedSize++;
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        this.front = (this.front)%this.elem.length;
        this.usedSize--;
        return true;
    }
    //得到队头元素
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return this.elem[this.front];
    }

    //得到队尾元素
    public int Rear(){
        if(isEmpty()){
            return -1;
        }
        int index = this.rear == 0 ? this.elem.length-1 : this.rear-1;
        return this.elem[index];
    }

}
