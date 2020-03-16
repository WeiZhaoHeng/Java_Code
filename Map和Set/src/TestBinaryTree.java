/**
 * Created with IntelliJ IDEA.
 * Description:二叉搜索树
 * User：WeiZhaoheng
 * Date: 2020/2/19
 * Time: 9:04
 */
public class TestBinaryTree {
    static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private Node root = null;

    //插入数据
    public boolean insert(int key){
        Node node = new Node(key);
        if(root == null){
            root = node;
            return true;
        }
        Node parent = null;
        Node cur = this.root;
        while(cur != null){
            if(cur.data == key){
                return false;
            }else if(cur.data < key){
                parent = cur;
                cur = cur.right;
            }else{
                parent = cur;
                cur = cur.left;
            }
        }
        if(parent.data < key){
            parent.right = node;
        }else{
            parent.left = node;
        }
        return true;

    }


    //查找 key
    public Node search(int key){
        Node cur = root;
        while(cur != null){
            if(cur.data < key){
                cur = cur.right;
            }else if(cur.data > key){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }

    //中序遍历打印
    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    //前序遍历
    public void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    //删除 key
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.data == key) {
                //找到了要删除的节点
                removeNode(parent,cur);
                return;
            }else if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }
    private void removeNode(Node parent,Node cur){

        //要删除的节点没有左孩子
        if(cur.left == null) {

            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        //要删除的节点没有右孩子
        }else if(cur.right == null) {

            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }

        }else {//要删除的节点 左右孩子都存在
            //在 cur 的右边找最小值来替换 cur
            Node targetParent = cur;//要替换节点的父亲节点
            Node target = cur.right;//要替换的节点
            while(target.left != null){
                targetParent = target;
                target = target.left;
            }
            cur.data = target.data;

            if(target == targetParent.left){
                targetParent.left = target.right;
            }else{
                targetParent.right = target.right;
            }
        }

    }




}
