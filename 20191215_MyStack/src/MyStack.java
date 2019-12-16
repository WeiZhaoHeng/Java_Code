/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 17:58
 */
class MyStack<T> {
    private T[] elem;
    private int top;
    public MyStack(){
        this.elem = (T[]) new Object[10];
        this.top = 0;
    }
    private boolean isFull(){
        return this.top == this.elem.length;
    }
    //入栈
    public void push(T val){
        if(isFull()){
            return ;

        }
        this.elem[this.top] = val;
        this.top++;
    }
    private boolean isEmpty(){
        return this.top == 0;
    }
    //出栈
    public T pop(){
        if(isEmpty()){
            return null;
        }
        T tmp = this.elem[top-1];//保存出栈的数据
        this.top--;//出栈
        return tmp;

    }
    //给出栈顶元素但是不出栈
    public T getPop(){
        if(isEmpty()){
            return null;
        }
        return this.elem[top-1];//保存出栈的数据

    }

}
