/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/2
 * Time: 15:09
 */
class ListNode{
    public int data;
    public ListNode next;
    public ListNode random;


    public ListNode(int data,ListNode next,ListNode random){
        this.data = data;
        this.next = next;
        this.random = null;
    }
}
class MySingleList {
    public ListNode head;
    public MySingleList(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data,null,null);
        //判断是否是第一次插入
        if(this.head == null){
            //是第一次，直接将 head 指向 node
            this.head = node;
        }else{
            //不是第一次，note.next 指向 head，并且将 head 指向 node
            node.next = this.head;
            this.head = node;
        }
    }
    //打印单链表数据
    public void display(){
        //如果 head 是空则无需打印
        if(this.head == null){
            return;
        }
        //定义一个节点 cur 来遍历
        ListNode cur = this.head;
        //如果 cur 为空则跳出循环(意思是后面没有节点了)
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //给随机指针
    public void randomPointer(){
        if(this.head == null){
            return;
        }
        ListNode cur = this.head;
        while(cur != null){
            if(cur.random == null){
                cur.random = cur.next;
            }
            cur = cur.next;
        }
    }
    //打印 cur 的地址
    public void display2(){
        //如果 head 是空则无需打印
        if(this.head == null){
            return;
        }
        //定义一个节点 cur 来遍历
        ListNode cur = this.head;
        //如果 cur 为空则跳出循环(意思是后面没有节点了)
        while(cur != null){
            System.out.print(cur+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //打印单链表的随即指针
    public void display1(){
        //如果 head 是空则无需打印
        if(this.head == null){
            return;
        }
        //定义一个节点 cur 来遍历
        ListNode cur = this.head;
        //如果 cur 为空则跳出循环(意思是后面没有节点了)
        while(cur != null){
            System.out.print(cur.random+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    //要求返回这个链表的深拷贝。
    public ListNode copyRandomLists(ListNode head){
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while(cur != null){
            ListNode node = new ListNode(cur.data ,cur.next,null);
            ListNode tmp = cur.next;
            cur.next = node;
            cur = tmp;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        ListNode newHead = cur.next;
        while(cur.next != null){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            cur = tmp;
        }
        return newHead;
    }
/*    public  ListNode copyRandomLists(ListNode head){
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
    }*/

    //打印 cur 的地址
    public void display3(ListNode head){
        //如果 head 是空则无需打印
        if(head == null){
            return;
        }
        //定义一个节点 cur 来遍历
        ListNode cur = head;
        //如果 cur 为空则跳出循环(意思是后面没有节点了)
        while(cur != null){
            System.out.print(cur+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //打印单链表的随即指针
    public void display4(ListNode head){
        //如果 head 是空则无需打印
        if(head == null){
            return;
        }
        //定义一个节点 cur 来遍历
        ListNode cur = head;
        //如果 cur 为空则跳出循环(意思是后面没有节点了)
        while(cur != null){
            System.out.print(cur.random+" ");
            cur = cur.next;
        }
        System.out.println();
    }



}
