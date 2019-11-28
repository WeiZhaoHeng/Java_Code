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

    /**
     * 找到 index -1 位置的节点，返回当前节点的引用
     * @param index
     * @return
     */
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


}
