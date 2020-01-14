/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 14:24
 */
public class MyArrayQueue <T>{
    public T[] elem;
    public int front;
    public int rear;
    public int usedSize;

    public MyArrayQueue(int k) {
        this.elem = (T[])new Object[k+1];
        this.front = 0;
        this.rear = 0;
        this.usedSize = 0;
    }

    //空
    public boolean isEmpty(){
        return this.front == this.rear;
    }

    //满
    public boolean isFull(){
        return (this.rear+1) % this.elem.length == this.front;
    }

    //入队
    public boolean enQueue(T val){
        if(isFull()){
            return false;
        }
        this.elem[this.rear] = val;
        this.rear = (this.rear+1) % this.elem.length;
        this.usedSize++;
        return true;
    }

    //出队
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        this.front = (this.front+1) % this.elem.length;
        this.usedSize--;
        return true;
    }

    //得到对头
    public T getFront(){
        if(isEmpty()){
            return null;
        }
        return this.elem[this.front];
    }

    //得到队尾元素
    public T getRear(){
        if(isEmpty()){
            return null;
        }
        int index = this.rear == 0 ? this.elem.length-1:this.rear-1;
        return this.elem[index];
    }
}
