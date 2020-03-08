/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/2/18
 * Time: 17:19
 */
public class MySingleList<T extends Comparable<T>> {

    static class ListNode<T extends  Comparable<T>>  {
        private T data;
        private ListNode<T> next;
        private ListNode<T> random;

        public ListNode() {
        }

        public ListNode(T data) {
            this.data = data;
            this.next = null;
        }

        public ListNode(T data,ListNode next,ListNode random) {
            this.data = data;
            this.next = null;
            this.random = null;
        }

        @Override
        public boolean equals(Object obj) {
            ListNode cur = (ListNode)obj;
            return this.data == cur.data;
        }


    }

    private ListNode<T> head;//标记头节点

    public MySingleList() {
        this.head = null;
    }


    //头插法
    public void addFirst(T data){
        ListNode<T> node = new ListNode<T>(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(T data){
        ListNode<T> node = new ListNode<T>(data);
        ListNode cur = this.head;
        if(this.head == null){
            this.head = node;
        }else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //打印单链表
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

    //插入到 index 位置
    public boolean addIndex(int index,T data){
        if(index < 0 || index > getLength()){
            return false;
        }
        if(index == 0){
            addLast(data);
            return true;
        }
        ListNode prev = searchIndex(index);
        ListNode<T> node = new ListNode<T>(data);
        node.next = prev.next;
        prev.next = node;
        return true;
    }
    //找到 index  位置的节点，返回当前节点的引用
    private ListNode searchIndex(int index) {
        ListNode prev = this.head;
        int count = 0;
        while(count < index-1){
            prev = prev.next;
            count++;
        }
        return prev;
    }
    //计算链表的长度
    private int getLength() {
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //查找是否包含关键字 KEY
    public boolean contains(T key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data.equals(key)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public ListNode contains2(T key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除关键字 key 节点
    public void remove(T key){
        if(this.head.data.equals(key)){
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有要删除的节点");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }
    private ListNode searchPrev(T key) {
        ListNode prev = this.head;
        while(prev.next != null){
            if(prev.next.data.equals(key)){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    //删除所有关键字位 key 的节点
    public void removeAllKey(T key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur != null){
            if(cur.data.equals(key)){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data.equals(key)){
            this.head = this.head.next;
        }
    }

    //清空链表
    public void clear(){
        while(this.head.next != null){
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }

    //反转一个单链表
    public ListNode reverseList(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while(cur != null){
            ListNode curNext = cur.next;
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //打印逆置后的链表
    public void display(ListNode newHead){
        if(newHead == null){
            return ;
        }
        ListNode cur = newHead;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //给定一个带有头结点head的非空单链表,返回链表的中间结点。
    // 如果有两个中间结点，则返回第二个中间结点
    // 第一种做法
    public ListNode middleNode1(){
        ListNode cur = this.head;
        int count = 0;
        int tmp = getLength()/2;
        while(count != tmp){
            cur = cur.next;
            count += 1;
        }
        return cur;
    }

    //第二种做法(只遍历一遍)
    public ListNode middleNode2(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，输出倒数第 K 个节点
    public ListNode findK1(int k){
        ListNode fast = this.head;
        ListNode slow = this.head;
        if(k > getLength() || k <= 0){
            System.out.println("该节点超出范围");
            return null;
        }else{
            while(k-1 > 0){
                fast = fast.next;
                k--;
            }
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
    public ListNode findK2(int k){
        ListNode fast = this.head;
        ListNode slow = this.head;
        if(k <= 0 || this.head == null){
            System.out.println("该节点超出范围");
            return null;
        }
        while(k-1 > 0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }else{
                System.out.println("该节点超出范围");
                return null;
            }
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    //找到以 X 为基准分割链表
    public ListNode partition(T x){
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data.compareTo(x) < 0){
                if(bs == null){
                    bs = cur;
                    be = cur;
                }else{
                    be.next = cur;
                    be = be.next;
                }
            }else{
                if(as == null){
                    as = cur;
                    ae = cur;
                }else{
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null){
            return as;
        }
        be.next = as;
        if(as != null){
            ae.next = null;
        }
        return bs;
    }

    //删除有序链表中的重复节点
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode<T> newHead = new ListNode<T>();
        ListNode tmp = newHead;
        while(cur != null){
            if(cur.next != null && cur.data.equals(cur.next.data)){
                while(cur.next != null && cur.data.equals(cur.next.data)){
                    cur = cur.next;
                }
                //cur = cur.next;//如果这句话存在，则说明重复的节点会全部被删除 1,1,1,2 ==> 2
            }else{
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }


    //判断回文链表
    public boolean chkPalindrome(){
        if(this.head == null){
            return false;
        }
        if(this.head.next == null){
            return true;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while(slow != this.head){
            if(!slow.data.equals(this.head.data)){
                return false;
            }
            if(this.head.next == slow){
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }

    //给一个单链表，判断是否有环
    public boolean hasCycle(){
        if(this.head == null){
            return false;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //找到链表中环的入口
    public ListNode detectCycle(){
        if(this.head == null){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                slow = this.head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    //创造一个环
    public void creatCycle(){
        ListNode cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }



}
