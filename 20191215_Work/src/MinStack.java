import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 20:09
 */
class MinStack {
    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();
    //放入
    public void push(int x){
        stack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        }else{
            int tmp = minStack.peek();
            if(tmp >= x){
                minStack.push(x);
            }
        }
    }
    //取出
    public void pop(){
        int tmp = stack.pop();
        if(tmp == minStack.peek()){
            minStack.pop();
        }
    }
    //得到普通的栈顶元素
    public int top(){
        return stack.peek();
    }

    //得到最小元素
    public int getMin(){
        if(minStack.empty()){
            return -1;
        }
        return minStack.peek();
    }

}
