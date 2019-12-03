import com.sun.scenario.effect.impl.prism.ps.PPSLinearConvolvePeer;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/3
 * Time: 16:53
 */
public class Test {
    //判断两个单链表是否相交(地址相同),返回相交点
    public static ListNode intersect(ListNode headA ,ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode pL = headA;
        ListNode pS = headB;
        int lenA = 0;
        int lenB = 0;
        while(pL != null){
            lenA++;
            pL = pL.next;

        }
        while(pS != null){
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        int len = lenA - lenB;
        if(len < 0){
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        while(len > 0){
            pL = pL.next;
            len--;
        }
        while(pL != null){
            pL = pL.next;
            pS = pS.next;
            if(pL == pS){
                return pL;
            }
        }
        return null;

    }
    public static void creatCut(ListNode headA,ListNode headB){
        headA.next = headB.next.next;
    }

    //将两个有序链表合并为一个有序链表

    public static ListNode mergeTwoLists(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(headA != null && headB != null){
            if(headA.data<headB.data){
                tmp.next = headA;
                headA = headA.next;
            }else{
                tmp.next = headB;
                headB = headB.next;
            }
            tmp = tmp.next;
        }
        if(headA == null){
            tmp.next = headB;
        }
        if(headB == null){
            tmp.next = headA;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        MySingList mySingList1 = new MySingList();
        MySingList mySingList2 = new MySingList();
        mySingList1.addFirst(11);
        mySingList1.addFirst(9);
        mySingList1.addFirst(7);
        mySingList1.addFirst(5);
        mySingList1.addFirst(3);
        mySingList1.addFirst(1);
        mySingList2.addFirst(12);
        mySingList2.addFirst(10);
        mySingList2.addFirst(8);
        mySingList2.addFirst(6);
        mySingList2.addFirst(4);
        mySingList2.addFirst(2);
        mySingList1.display();
        System.out.println("=======================");
        mySingList2.display();
/*        creatCut(mySingList1.head,mySingList2.head);
        ListNode node = intersect(mySingList1.head,mySingList2.head);
        System.out.println(node.data);*/
        System.out.println("=======================");
        ListNode node = mergeTwoLists(mySingList1.head,mySingList2.head);
        MySingList.display1(node);

    }
}
