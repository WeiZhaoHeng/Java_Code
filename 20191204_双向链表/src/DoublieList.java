/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/4
 * Time: 14:24
 */

class ListNode{
    public int data;
    public ListNode next;
    public ListNode prev;
    public ListNode (int data){
        this.data = data;
    }
}
class DoublieList {
    public ListNode head;
    public ListNode last;
    public DoublieList(){
        this.head = head;
        this.last = last;
    }
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }

    }
    //打印链表数据
    public void display(){
        if(this.head == null){
            return;
        }
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //计算长度
    public int getLength(){
        int count = 0;
        if(this.head == null){
            return count;
        }else {
            ListNode cur = this.head;
            while (cur != null){
                count++;
                cur = cur.next;
            }
        }
        return count;
    }
    //插入任意位置index
    public void addIndex(int index,int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(index < 0||index > getLength()){
            return ;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == getLength()){
            addLast(data);
            return;
        }
        while(index >0){
            cur =cur.next;
            index--;
        }
        node.prev = cur.prev;
        node.next = cur;
        cur.prev.next = node;
        cur.prev = node;


    }

    public void remove(int key){
        if(this.head ==null){
            System.out.println("链表为空");
            return ;
        }
        ListNode cur = this.head.next;
        while(cur.next != null){
            if(cur.data == key){
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
            }
            cur = cur.next;

        }
        if(this.head.data == key){
            this.head = this.head.next;
            this.head.prev = null;
        }
        if(this.last.data == key){
            this.last.prev.next = null;
            this.last = this.last.prev;
        }
    }

    public void clear(){
        while(this.head == null){
            ListNode cur = this.head.next;
            this.head.prev = null;
            this.head.next = null;
            this.head = cur;

        }
        this.last = null;
    }


}
