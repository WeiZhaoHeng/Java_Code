/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/3
 * Time: 16:54
 */
class ListNode{
    public int data;
    public ListNode next;
    public ListNode random;
    public ListNode(int data){
        this.data = data;
        this.next = null;
        this.random = null;
    }
    public ListNode(int data,ListNode next,ListNode random){
        this.data = data;
        this.next = next;
        this.random = null;
    }
}
 class MySingList {
    public ListNode head;
    public MySingList(){
        this.head = null;
     }

     public void addFirst(int data){
         ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else{

            node.next = this.head;
            this.head = node;
        }

     }
     public static void display1(ListNode node){
        if(node == null){
            return;
        }else{
            while(node != null){
                System.out.print(node.data+" ");
                node = node.next;
            }
            System.out.println();
        }
     }
     public  void display(){
        if(this.head == null){
            return ;
        }else{
           ListNode cur = this.head;
           while(cur != null){
               System.out.print(cur.data+" ");
               cur = cur.next;
           }
            System.out.println();
         }

     }

     public ListNode copyRandomLists(ListNode head){
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while(cur !=null){
            ListNode node = new ListNode(cur.data ,cur.next,null);
            ListNode tmp = cur.next;
            cur.next = node;
            cur = tmp;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
                cur = cur.next.next;
            }else{
                cur = cur.next.next;
            }
        }
        cur = head;
        ListNode newHead = cur.next;
        while(cur !=null){
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            cur = tmp;

        }
        return newHead;
     }
}
