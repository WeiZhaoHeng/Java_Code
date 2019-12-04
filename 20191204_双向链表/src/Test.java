/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/4
 * Time: 14:23
 */
public class Test {
    public static void main(String[] args) {
        DoublieList doublieList = new DoublieList();
        doublieList.addFirst(1);
        doublieList.addFirst(2);
        doublieList.addLast(3);
        doublieList.addLast(4);
        doublieList.display();
        int size = doublieList.getLength();
        System.out.println(size);
        doublieList.addIndex(3,3);
        doublieList.display();
        System.out.println("=============================");
        doublieList.remove(3);
        doublieList.display();

    }
}
