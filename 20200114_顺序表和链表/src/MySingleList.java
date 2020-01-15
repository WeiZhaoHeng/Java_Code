/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 20:49
 */
class ListNode<T>{
    public T data;
    public ListNode next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }
}
class MySingleList<T> {
    public ListNode head;

    public MySingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(T data){
        ListNode<T> node = new ListNode<>(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(T data){
        ListNode<T> node = new ListNode<>(data);
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

    //打印单链表的数据
    public void display(){
        if(this.head == null){
            return ;
        }
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //插入到 index 位置
    public boolean addIndex(int index ,T data){
        if(index < 0 || index > getLength()){
            return false;
        }
        if(index == 0){
            addLast(data);
            return true;
        }
        ListNode prev = searchIndex(index);
        ListNode<T> node = new ListNode<>(data);
        node.next = prev.next;
        prev.next = node;
        return true;
    }
    private ListNode searchIndex(int index){
        ListNode prev = this.head;
        int count = 0;
        while(count < index -1){
            prev = prev.next;
            count++;
        }
        return prev;
    }

    //计算链表的长度
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //查找是否包含关键字
    public boolean contains(T key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除关键字 key 的节点
    public void remove(T key){
        if(this.head.data == key){
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
    private ListNode searchPrev(T key){
        ListNode prev = this.head;
        while(prev.next != null){
            if(prev.next.data == key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除所有值为 key 的节点
    public void removeAllkey(T key){
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
    public void display0(ListNode newHead){
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
}
