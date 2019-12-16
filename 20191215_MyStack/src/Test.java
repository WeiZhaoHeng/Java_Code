/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 17:58
 */
public class Test {
    public static void main(String[] args) {
        MyStack2<Integer> myStack = new MyStack2<>();
        myStack.push(12);
        myStack.push(13);
        myStack.push(14);
        myStack.push(15);
        System.out.println(myStack.pop());
        System.out.println(myStack.getPop());
    }
}
