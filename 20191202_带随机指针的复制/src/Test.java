/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/2
 * Time: 15:08
 */
public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(6);
        mySingleList.addFirst(5);
        mySingleList.addFirst(4);
        mySingleList.addFirst(3);
        mySingleList.addFirst(2);
        mySingleList.addFirst(1);
        mySingleList.display();
        mySingleList.display2();
        mySingleList.randomPointer();
        mySingleList.display1();
        ListNode node = mySingleList.copyRandomLists(mySingleList.head);
        System.out.println(node);
        mySingleList.display3(node);
        mySingleList.display4(node);
    }
}
