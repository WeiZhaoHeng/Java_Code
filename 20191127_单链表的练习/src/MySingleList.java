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

    //打印链表
    public void display(){
        if(this.head == null){
            System.out.println("该链表为空");
        }else{
            ListNode cur = this.head;
            while(cur != null){
                System.out.print(cur.data+" ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
    //打印指定ListNode的链表
    public void display1(ListNode head){
        if(head == null){
            System.out.println("空链表");
            return;
        }
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else{
            ListNode cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //计算长度
    public int getLength(){
        int count = 0;
        if(this.head == null){
            return count;
        }
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //查找index 前一个节点
    private ListNode searchIndex(int index){
        ListNode prev = this.head;
        while(index - 1> 0){
            prev = prev.next;
            index--;
        }
        return prev;
    }

    //index 位置插入
    public void addIndex(int index,int data){
        if(index < 0 || index > getLength()){
            System.out.println("位置不合法");
            return;
        }
        ListNode node = new ListNode(data);
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == getLength()){
            addLast(data);
            return;
        }
        ListNode prev = searchIndex(index);
        node.next = prev.next;
        prev.next = node;
    }

    //查找关键字key
    public ListNode findKey(int key){
        if(this.head == null){
            System.out.println("链表为空");
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


    //找前驱
    private ListNode searchBefore(int key){
        ListNode prev = this.head;
        while(prev.next != null){
            if(prev.next.data == key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    //删除关键字 key
    public void remove(int key){
        if(this.head == null){
            return ;
        }
        if(this.head.data == key){
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchBefore(key);
        if(prev == null){
            System.out.println("没有要删除的节点");
            return ;
        }
        prev.next = prev.next.next;
    }

    //删除所有key
    public ListNode removeAllKey(int key){
        if(this.head == null){
            System.out.println("链表为空");
            return null;
        }
        ListNode cur = this.head.next;
        ListNode prev = this.head;
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
        return this.head;
    }

    //清空链表
    public void clear(){
        this.head = null;
    }

    //反转链表
    public ListNode reverse(){
        if(this.head == null){
            System.out.println("空链表");
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
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //返回中间节点
    public ListNode middle(){
        if(this.head == null){
            System.out.println("空链表");
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null&& fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //返回倒数第K个节点
    public ListNode reciprocalK(int k){
        if(k <= 0 ||this.head == null){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        /*while(k - 1 > 0){
            fast = fast.next;
            k--;
        }
        if(fast.next == null){
            return null;
        }*/
        while(k-1>0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }
            else{
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

    //以X为基准分割
    public ListNode partition(int x){
        if(this.head == null){
            System.out.println("空链表");
            return null;
        }
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data < x){
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

    //删除重复的节点
    public ListNode removeRepetition(){
        if(this.head == null){
            System.out.println("空链表");
            return null;
        }
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1 );
        ListNode prev = newHead;
        while(cur !=null){
            if(cur.next != null&&cur.data == cur.next.data){
                while(cur.next != null&&cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
            }
        }
        if(prev.next != null){
            prev.next = null;
        }
        return  newHead.next;
    }

    //判断回文
    public boolean plalindrome(){
        if(this.head == null){
            return false;
        }
        if(this.head.next == null){
            return true;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null&&fast.next != null){
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
        ListNode head = this.head;
        while(head != slow){
            if(head.data != slow.data){
                return false;
            }
            if(head.next == slow){
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
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

    //查找是否包含关键字 key
    public boolean contains1(int key){
        ListNode cur = this.head;
        while(cur !=null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public ListNode contains2(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return cur;
            }
            cur =cur.next;
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
        //如果删除的节点是头节点
        if(this.head.data == key){
            this.head = this.head.next;
            return ;
        }
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有要删除的节点");
            return ;
        }
        ListNode del = prev.next;

        prev.next = del.next;
    }

    //删除所有值为 key  的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur != null){
            if(prev.next.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev =cur;
                cur = cur.next;
            }
        }

        //头要放在最后处理
        if(this.head.data ==key ){
            this.head = this.head.next;
        }
    }

    //清空单链表
    public void clear(){
        while(this.head.next != null){
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }
}*/

/*    //反转一个单链表(会产生一个新的头节点需要用display1进行打印)
    public ListNode reverseList0(){
        ListNode prev = null;//
        ListNode cur = this.head;
        ListNode newHead = null;
        while(cur != null){//如果 cur 为空则结束循环
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
    public void display1(ListNode newHead){
        //如果 head 是空则无需打印
        if(newHead == null){
            return;
        }
        //定义一个节点 cur 来遍历
        ListNode cur = newHead;
        //如果 cur 为空则跳出循环(意思是后面没有节点了)
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //反转一个单链表(可以选择是否打印的程序)
    public void reverseList1(boolean want){
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = this.head;
        while(cur != null){
            ListNode curNext = cur.next;
            if(curNext == null)
                newHead = cur;
            cur.next = prev;
            prev = cur;
            cur = curNext;

        }
        //如果want==true-->打印，否则不打印
        if(want){
            cur = newHead;
            while(cur != null){
                System.out.print(cur.data+" ");
                cur = cur.next;
            }
            System.out.println();
        }

    }

    //逆转后也可直接用 dispaly 进行打印
    public void reverseList2(){
        ListNode prev = null;
        ListNode cur = this.head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        //上面的while执行完后 prev 就是第一个节点
        //这里将头直接定位到 prev
        this.head = prev;
    }

    //利用头插法完成逆置

    // 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
    //第一种做法
    public ListNode middleNode1(){
        ListNode cur = this.head;
        int count = 0;
        int tmp = getLength()/2;
        while(count != tmp){
            cur = cur.next;
            count = count +1;
        }
        return cur;
    }
    //第二种做法(只遍历一遍)
    public ListNode middleNode2(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null&&fast.next != null){//这里要用 && 不然会出现空指针异常
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode findK1(int k){
        ListNode fast = this.head;
        ListNode slow = this.head;

        if(k>getLength()||k <= 0){
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
    //第二种情况
    public ListNode findK2(int k){

        ListNode fast = this.head;
        ListNode slow = this.head;
        if(k <= 0||this.head == null){
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


    }*/
//逆置要用display1打印
/*
    public ListNode reversList0(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while(cur != null){
            ListNode curNext = cur.next;
            if(curNext == null)
                newHead = cur;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void display1(ListNode newHead){
        if(newHead == null){
            return;
        }
        ListNode cur = newHead;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //逆置，选择是与否要打印
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

    //逆置 可以直接用display打印
    public void reverseList2(){
        ListNode prev = null;
        ListNode cur = this.head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = prev;
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

    //case 2:
    public ListNode middleNode2(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow =slow.next;
        }
        return slow;
    }

    //输出倒数第k个节点
    public ListNode findK1(int k){
        ListNode fast = this.head;
        ListNode slow = this.head;
        if(k<=0||k>getLength()){
            System.out.println("该节点超出范围" );
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
            System.out.println("该节点超出范围" );
            return null;
        }
        while(k-1>0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }
            else{
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
	
	
	    //找到以 X 为基准分割列表
    public ListNode partition(int x){
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data < x){
                //是不是第一次插入
                if(bs == null){
                    bs = cur;
                    be = cur;
                }else{
                    be.next = cur ;
                    be = be.next;
                }
            }else{
                //是不是第一次插入
                if( as == null){
                    as = cur;
                    ae = cur;
                }else{
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //第一个去区间没有数据
        if(bs == null){
            return as;
        }
        be.next = as;
        if(as != null){
            as.next = null;
        }
        return bs;
    }

    //删除重复的节点.eg:1->2->3->3->4->4->5 ==》1->2->5
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(cur != null){
            //重复的节点
            if(cur.next != null&&cur.data == cur.next.data){
                //每一次都需要判断 cur.next
                while(cur.next != null&&cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //最后一个节点如果也是重复的
        //需要将 tmp.next = null
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
        while(fast != null&&fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode cur = slow.next;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //判断回文
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
    //给一个单链表，判断是否有环
    public boolean hasCycle(){
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

    //找有环的链表的入口节点
    public ListNode detectCycle(){
        if(this.head == null){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null&&fast.next != null){
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




}
*/
