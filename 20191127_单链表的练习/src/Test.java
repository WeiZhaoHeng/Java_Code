/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/11/27
 * Time: 17:14
 */
public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();

        mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(4);
        mySingleList.addFirst(5);
        mySingleList.addFirst(2);
        mySingleList.display();
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.addLast(5);
        mySingleList.addLast(2);
        mySingleList.display();
        mySingleList.addIndex(6,1);
        mySingleList.display();
        mySingleList.removeAllKey(2);
        mySingleList.display();
        System.out.println("================================");
        mySingleList.clear();
        mySingleList.display();
    }
}
