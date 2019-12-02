import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/11/27
 * Time: 17:17
 */
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

class MySingleList{
    public ListNode head;
    public MySingleList(){
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }
        ListNode cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }

    //打印单链表数据
    public void diaplay(){
        if(this.head == null){
            System.out.println("该链表为空");
            return;
        }
        ListNode cur = this.head;
        while(cur !=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //计算链表的长度
    public int getLength(){
        int count = 0;
        if(this.head == null){
            return count;
        }
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //插入到 index 位置
    public boolean addIndex(int index,int data){
        if(index < 0||index>getLength()){
            System.out.println("该位置不合法");
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        ListNode prev = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        return true;

    }
        //找 index-1 的节点
        public ListNode searchIndex(int index){
            ListNode cur = this.head;
            int count = 0;
            while(count < index-1){
                cur = cur.next;
                count++;
            }
            return cur;
        }

    //查找是否包含关键字 Key-->返回值为boolea类型
    public boolean findKey(int key){
        if(this.head == null){
            return false;
        }
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //查找是否包含关键字 Key-->返回值为引用
    public ListNode findKey1(int key){
        if(this.head == null){
            return null;
        }
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除关键字 key 的节点
    public void remove(int key){
        if(this.head == null){
            System.out.println("该链表为空");
            return ;
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
        ListNode prev = searchAhead(key);
        if(prev == null){
            System.out.println("没有要删除的节点");
            return ;
        }
        prev.next = prev.next.next;
    }
        //找前驱
        public ListNode searchAhead(int key){
            ListNode cur = this.head;
            while(cur != null){
                if(cur.data == key){
                    return cur;
                }
                cur = cur.next;
            }
            return null;
        }

    //删除所有值为 key 的节点
    public void removeAll(int key){
        if(this.head == null){
            System.out.println("该链表为空");
            return ;
        }
        ListNode cur = this.head.next;
        ListNode prev = this.head;
        while(cur !=null){
            if(cur.data == key){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }

    }

    //清空单链表
    public void clear(){
        if(this.head == null){
            return ;
        }
        this.head = null;
    }

    //反转一个单链表
    public ListNode reverseLsit(){
        if(this.head == null){
            return null;
        }
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while(cur != null){
            ListNode curNext = cur.next;
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur ;
            cur = curNext;
        }
        return newHead;
    }

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
    public ListNode middleNode(){
        if(this.head == null){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null&&fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode findK(int k){
        if(k <= 0||this.head == null){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(k-1 > 0){
            if(fast.next == null){
                return null;
            }
            fast = fast.next;
            k--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }





}



























/*class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySingleList {

    public ListNode head;
    public MySingleList(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = head.next;
        if(this.head == null){
            this.head = node;
        }else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
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

    *//**
     * 找到 index -1 位置的节点，返回当前节点的引用
     * @param index
     * @return
     *//*
    private ListNode searchIndex(int index){
        ListNode prev = this.head;
        int count =0;
        while(count < index-1){
            prev = prev.next;
            count++;
        }
        return prev;
    }
    //插入到 index 位置
    public boolean addIndex(int index,int data){
        if(index < 0||index >getLength()){
            return false;
        }
        if(index == 0){
            addLast(data);
            return true;
        }
        ListNode prev = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node ;
        return true;
    }
    //计算链表的长度
    public int getLength(){
        int count =0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //查看是否包含某个关键字key
    public boolean contains1(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data ==key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public ListNode contains2(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data ==key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //用来找前驱
    private ListNode searchPrev(int key){
        ListNode prev = this.head;
        while(prev.next != null){
            if(prev.next.data == key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除关键字 key 的节点
    public void remove(int key){
        //删除的节点如果是头
        if(this.head.data == key){
            this.head = this.head.next;
            return ;
        }
        //通过找前驱来删除key，如果找不到返回null
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有要删除的节点");
            return ;

        }
        ListNode del = prev.next;
        //进行删除
        prev.next = del.next;
    }

    //删除所有值为 key  的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur != null){
            if(cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }

    //清空单链表
    public void clear(){
        //this.head = null;
        while(this.head.next != null){
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }

    //反转一个单链表(会产生一个新的头节点需要用display1行打印)
    public ListNode reverseLsit(){
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
    public void display1(ListNode newHead){
        if(newHead ==null){
            return ;
        }
        ListNode cur = newHead;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //反转单链表(可选择是否要打印)
    public void reverseList1(boolean want){
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = this.head;
        while(cur != null){
            ListNode curNext = cur.next;
            if(curNext == null){
                newHead = cur;

            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        if(want){
            cur = newHead;
            while(cur != null){
                System.out.print(cur.data+" ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    //逆置后可直接用display打印
    public void reverseList2(){
        ListNode prev = null;
        ListNode cur = this.head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next =prev;
            prev = cur;
            cur = curNext;
        }
        this.head = prev;
    }

    //利用头插法完成逆置
    public void reverseList3(){

    }

    // 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
    //第一种做法

    public ListNode middleNode1(){
        ListNode cur = this.head;
        int count =0;
        int tmp = getLength()/2;
        while(count != tmp){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //第二种做法
    public ListNode middleNode2(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null&& fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，输出倒数第K个节点
    public ListNode findK1(int k){
        ListNode fast = this.head;
        ListNode slow = this.head;
        if(k>getLength()||k<=0){
            System.out.println("该节点超出范围");
            return null;
        }else{
            while(k-1>0){
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
    //case 2:
    public ListNode findK2(int k){
        ListNode fast = this.head;
        ListNode slow = this.head;
        if(k<=0||this.head == null){
            System.out.println("该节点超出范围");
            return null;
        }
        while(k-1>0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }else{
                System.out.println("该节点超出范围");
                return null;
            }
        }
        while(fast.next !=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //以 X 为基准分割链表
    public ListNode partition(int x){
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data < x){
                //是不是第一次插入数据
                if(bs == null){
                    bs = cur;
                    be = cur;
                }else{
                    be.next = cur;
                    be = be.next;
                }
            }else{
                //是不是第一次插入数据
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
        //第一个区间没有数据
        if(bs == null){
            return as;
        }
        be.next = as;
        if(as != null){
            as.next = null;
        }
        return bs;
    }

    //删除重复的节点。eg：1-2-3-3-4-4-5==》1-2-5
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(cur != null){
            //重复的节点
            if(cur.next !=null&& cur.data == cur.next.data){
                //每一次都需要判断 cur.next
                while(cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //最后一个节点如果也是重复的 与要将 tmp.next  =  null
        tmp.next = null;
        return newHead.next;
    }

    //判断回文
    public boolean chkPalindrome(){
        if(this.head == null){
            return false;
        }
        if(this.head.next == null){
            return true;
        }
        //找中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null&& fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode cur =slow.next;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //判断是否回文
        while(slow != this.head){
            if(slow.data != this.head.data){
                return false;
            }
            //针对于偶数个节点的判断
            if(this.head.next == slow){
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }

    //创造一个环
    public void creatCycle(){
        ListNode cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }

    //给一个单链表判断是否有环
    public boolean haasCycle(){
        if(this.head == null){
            return false;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null&&fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //找到有环的链表的入口节点
    public ListNode detectCycle(){
        if(this.head == null){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null&&slow != null){
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



}*/
