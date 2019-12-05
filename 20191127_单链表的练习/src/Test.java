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
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(3);
        mySingleList.addLast(5);
        mySingleList.addLast(4);
        mySingleList.addLast(4);

        mySingleList.display();
/*        System.out.println(mySingleList.getLength());
        mySingleList.addIndex(5,12);
        mySingleList.display();
        mySingleList.remove(12);
        mySingleList.display();
        System.out.println("=================================");
        ListNode node = mySingleList.removeAllKey(5);
        mySingleList.display();
        ListNode head= mySingleList.reverse();
        mySingleList.display1(head);
        ListNode node1 = mySingleList.middle();
        System.out.println(node1.data);
        ListNode  node = mySingleList.reciprocalK(6);
        System.out.println(node.data);
        ListNode node2 = mySingleList.partition(5);
        mySingleList.display1(node2);*/
        mySingleList.display1(mySingleList.removeRepetition());

    }









/*    //给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    //要求返回这个链表的深拷贝。
    public static ListNode copyRandomLists(ListNode head){
        if(head == null){
            return null;
        }
        //旧的和新的进行连接
        ListNode cur = head;
        while(cur != null){
            ListNode node = new ListNode(cur.data, cur.next, null);
            ListNode tmp = cur.next;
            cur.next = node;
            cur = tmp;
        }
        //修改random
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
                cur = cur.next.next;
            }else{
                cur = cur.next.next;
            }
        }
        //将新旧链表分开
        cur = head;
        ListNode newHead = cur.next;
        while(cur.next != null){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            cur = tmp;
        }
        return newHead;
    }


    //将两个有序链表合并为一个有序链表
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB){
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(headA != null&&headB != null){
            if(headA.data <headB.data){
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else{
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA != null){
            tmp.next = headA;
        }
        if(headB != null){
            tmp.next = headB;
        }
        return newHead.next;

    }
    //判断两个单链表是否相交(地址相同),返回相交点
    public static ListNode getIntersevtionNode(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode pL = headA;//指向长的链表
        ListNode pS = headB;//指向短的链表

        int lenA = 0;
        int lenB = 0;
        //求链表的长度
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
        if(len<0){
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        //让pL先走len步
        while(len>0){
            pL = pL.next;
            len--;
        }

        //开始一起走
        while(pL != pS){
            pL = pL.next;
            pS = pS.next;
        }

        ///可有可无
        if(pL == null){
            return null;
        }
        return pL;
    }
    //创造相交
    public static void creatCut(ListNode headA,ListNode headB){
        headA.next.next = headB.next.next.next;
    }*/
    public static void main1(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(1);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.addLast(7);
        mySingleList.addLast(9);
        mySingleList.addLast(11);
        mySingleList.display();
        System.out.println("=======================");


 /*        MySingleList mySingleList1 = new MySingleList();
        mySingleList1.addLast(2);
        mySingleList1.addLast(4);
        mySingleList1.addLast(6);
        mySingleList1.addLast(8);
        mySingleList1.addLast(11);
        mySingleList1.addLast(13);
        mySingleList1.addLast(14);
        mySingleList1.addLast(15);
        mySingleList1.display();
        creatCut(mySingleList.head,mySingleList1.head);
       System.out.println("======================");
        mySingleList.display1(mergeTwoLists(mySingleList.head,mySingleList1.head));
        System.out.println("=======================");
        System.out.println(getIntersevtionNode(mySingleList.head,mySingleList1.head).data);*/
/*        mySingleList.creatCycle();
        System.out.println(mySingleList.hasCycle());
        System.out.println(mySingleList.detectCycle().data);*/

/*        mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(4);
        mySingleList.addFirst(5);
        mySingleList.display();
        System.out.println("================================");
        mySingleList.reverseList2();
        mySingleList.display();
        System.out.println("================================");
        ListNode middleNode = mySingleList.middleNode2();
        System.out.println(middleNode.data);
        System.out.println("================================");*//*
        ListNode findK = mySingleList.findK2(2);
        System.out.println(findK.data);*/



    }
}