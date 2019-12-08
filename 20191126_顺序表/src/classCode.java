/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/11/26
 * Time: 15:41
 */
public class classCode {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.display();
        System.out.println(myArrayList.search(5));
        myArrayList.add(0,5);
        myArrayList.add(0,2);
        myArrayList.add(0,3);
        myArrayList.add(0,6);
        myArrayList.display();
        System.out.println("============================");
        System.out.println(myArrayList.search(6));
        System.out.println(myArrayList.getPos(2));
        myArrayList.setPos(0,12);
        myArrayList.display();
        myArrayList.remove(5);
        myArrayList.display();
        System.out.println(myArrayList.size());
        myArrayList.clear();
        myArrayList.display();


    }
}
