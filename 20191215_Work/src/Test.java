/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 20:09
 */
public class Test {

    public static void main1(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(-2);
        minStack.push(6);
        minStack.push(8);
        minStack.push(-2);
        minStack.push(9);
        minStack.pop();
        minStack.pop();

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
