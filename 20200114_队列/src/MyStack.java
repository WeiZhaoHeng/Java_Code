/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 13:29
 */
public class MyStack <T>{
    public T[] elem;
    public int top;

    public MyStack() {
        this.elem = (T[])new Object[10];
        this.top = 0;
    }

    public void push(T val){
        if(isFull()){
            return;
        }
        this.elem[this.top] = val;
        this.top++;
    }
    private boolean isFull(){
        return this.top == this.elem.length;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        this.top--;
        return this.elem[this.top];
    }
    private boolean isEmpty(){
        return this.top == 0;
    }

    public T get(){
        if(isEmpty()){
            return null;
        }
        return this.elem[this.top-1];
    }
}
