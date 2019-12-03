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
}
