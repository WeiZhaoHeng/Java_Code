/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/11/27
 * Time: 17:17
 */
class ListNode{
    public int data;
    public List_Node next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySingleList {

    public List_Node head;
    public MySingleList(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        List_Node node = new List_Node(data);
        if(this.head == null){
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        List_Node node = new List_Node(data);
        List_Node cur = head.next;
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
        List_Node cur = this.head;
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
    private List_Node searchIndex(int index){
        List_Node prev = this.head;
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
        List_Node prev = searchIndex(index);
        List_Node node = new List_Node(data);
        node.next = prev.next;
        prev.next = node ;
        return true;
    }
    //计算链表的长度
    public int getLength(){
        int count =0;
        List_Node cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }


}
