import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/16
 * Time: 19:45
 */

class TreeNode{
    char value;
    TreeNode left;
    TreeNode right;

    public TreeNode(char value) {
        this.value = value;
    }
}
public class BinaryTree {

    public BinaryTree(){

    }

    public TreeNode bulidTree(){
        TreeNode root = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return root;
    }

    //前序遍历
    public void  preOrderTraversal(TreeNode root){

        if(root == null){
            return;
        }
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);//递归
        preOrderTraversal(root.right);
    }
    //中序遍历
    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return ;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
    }
    //后序遍历
    public void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }


    //计算节点个数-->利用遍历思路(不建议)
    static int size = 0;
    public void getsize1(TreeNode root){
        if(root == null){
            return ;
        }
        size++;
        getsize1(root.left);
        getsize1(root.right);
    }

    /**
     * 左节点的个数加上有节点的个数最后加上根节点
     * @param root
     * @return
     */
    //计算节点个数-->利用子问题思路
    public int getSize(TreeNode root){
        if(root == null){
            return 0;
        }
        return getSize(root.left)+getSize(root.right)+1;
    }


    //求叶子结点的个数-->遍历思路(不建议)
    static int leafSize = 0;
    public void getLeafSize1(TreeNode root){
        if(root == null){
            return ;
        }else if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    //求叶子节点的个数-->子问题思路
    public int getLeafSize(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){//先判断root节点是否为叶子节点，
            return 1;                                      //如果是则返回 1
        }
        //如果root不是叶子节点，则判断他的左右
        return getLeafSize(root.left) + getLeafSize(root.right);
    }
    //求第K层节点的个数，相当于求当前root.left的K-1层+当前root.right的K-1层的节点的个数。
    public int getKLevelSize(TreeNode root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }


    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    public TreeNode find(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }
        TreeNode fl = find(root.left,val);
        if(fl != null){
            return fl;
        }
        TreeNode fr = find(root.right,val);
        if(fr != null){
            return fr;
        }
        return null;
    }

    //检查两棵树是否相同
    public boolean isSameTree(TreeNode p ,TreeNode q){
        //若在相同位置上存在有一个树的节点为空，则不相同返回 false
        if(p == null&&q != null || p != null&& q == null){
            return false;
        }
        //如果在想用位置上两个树的节点都为空，则相同返回 true
        if(p == null && q == null){
            return true;
        }
        //若在相同位置上两树的节点都不为空，且他们的值不相等，则不相同返回 false
        if(p.value != q.value){
            return false;
        }
        //遍历两个树上同一位置的节点
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //另一颗树的子树
    /**
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
     * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //若有一个空，则返回false
        if(s == null || t == null){
            return false;
        }
        //判断当前的s与t是否相同
        if(isSameTree(s,t)){
            return true;
        }
        //判断t是否是当前s.left的子树
        if(isSubtree(s.left,t)){
            return true;
        }
        //判断t是否是当前s.right的子树
        if(isSubtree(s.right,t)){
            return true;
        }
        return false;
    }

    //求二叉树的深度(从根到最远的叶子节点的距离)
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftD = maxDepth(root.left);//求左树的高度
        int rightD = maxDepth(root.right);//求右树的高度
        return leftD>rightD?leftD+1:rightD+1;

    }

    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);
        /*if(Math.abs(leftD-rightD) > 1){//Math.abs()---->求绝对值
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);*/
        return Math.abs(leftD-rightD) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //对称二叉树

    /**
     * 1.判断左树与右树书是否为空（同时为空则对称，有一个不为空则不对称，两个都不为空--2）；
     * 2.判断左树与右树的值是否相等
     * 3.判断左树的左 == 右树的右 && 左树的右 == 右树的左
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree){
        //如果有一个为空则对称
        if((leftTree != null && rightTree == null) || (leftTree == null && rightTree != null)){
            return false;
        }
        //如果两个都为空则对称
        if(leftTree == null && rightTree == null) {
            return true;
        }
        return leftTree.value == rightTree.value && isSymmetricChild(leftTree.left,rightTree.right)
                && isSymmetricChild(leftTree.right,rightTree.left);
    }


    //前中后序的非递归实现

    //前序

    /**
     * 要利用栈来完成
     * @param root
     */
    public void preOrderTraversalNor(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();//定义一个栈
        TreeNode cur = root;//定义一个节点来遍历二叉树
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);//入栈
                System.out.print(cur.value+" ");
                cur = cur.left;
            }
            cur = stack.pop();//出栈
            cur = cur.right;
        }
    }

    //中序
    public void inOrderTraversalNor(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null|| !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.value);
            cur = cur.right;
        }
    }

    //后序
    public void postOrderTraversalNor(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null|| !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.right == prev){
                stack.pop();
                System.out.print(cur.value+" ");
                prev = cur;
                cur = null;
            }else{
                cur = cur.right;
            }
        }
    }

    //层序遍历

    /**
     * 依赖于队列
     */
    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.value+" ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }


    public List<List<Character>> levelOrder(TreeNode root){
        List<List<Character>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Character> list = new ArrayList<>();
            while(size > 0){
                TreeNode cur = queue.poll();
                System.out.println(cur.value+" ");
                list.add(cur.value);
                size--;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }
	
	    //判断是否是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);

            }else{
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.peek();
            if(cur != null){
                return false;
            }else{
                queue.poll();
            }
        }
        return true;
    }


    //构建一个二叉树
    public int i = 0;
    public TreeNode buildTree(String str){
        TreeNode root = null;
        if(str.charAt(i) != '#'){
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);

        }else{
            i++;
        }
        return root;
    }

    //3. 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先 。

    /**
     * 根据前序遍历的方式完成
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree = lowestCommonAncestor(root.right,p,q);
        if(leftTree != null && rightTree != null){
            return root;
        }
        if(leftTree != null){
            return leftTree;
        }
        if(rightTree != null){
            return  rightTree;
        }
        return null;
    }





    //二叉树搜索树转换成排序双向链表
    //返回的是双向链表的头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        //这个函数，执行完成后，二叉搜索树的结构已经被改变了
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        //一路向左
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }
        //用来改变二叉树的结构
        TreeNode prev = null;
        public void ConvertChild(TreeNode pCur) {
            if(pCur == null) {
                return;
            }
            ConvertChild(pCur.left);
            pCur.left = prev;
            if(prev != null) {
                prev.right = pCur;
            }
            prev = pCur;
            ConvertChild(pCur.right);
        }

    //根据一棵树的前序遍历与中序遍历构造二叉树。
    public TreeNode buildTree(int[] preorder, int[] inorder){
            return null;
    }



    // 二叉树创建字符串。
    public void tree2strChild(TreeNode t,StringBuilder sb){
        if(t == null){
            return;
        }
        sb.append(t.value);
        if(t.left == null){
            if(t.right == null){
                return;
            }else{
                sb.append("()");
            }
        }else{
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }

        if(t.right == null){
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }
    }
    public String tree2str(TreeNode t){
        StringBuilder sb = new StringBuilder();
        tree2strChild(t,sb);
        return sb.toString();
    }






}
