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
    public TreeNode find(TreeNode root, char val){
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
     * 1.判断左树与右树书是否为空（同时为空则对称，有一个不为空则不对称，两个都不为空-->2）；
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

    /**
     * 1.利用队列来完成操作
     * 2.第一步判断参数 root 是否为空--》如果不是空则将 root 入队
     *   第二步定义 cur ，从队头开始遍历并让头元素出队，如果 cur != null 则让当前节点的左右入队
     *      如果 cur == null 则对于完全二叉树来说已经全部出队，对于不完全二叉树来说还未完全出队
     *   第三步根据第二部的结论来判断是否是完全二叉树
     *      定义 cur ，从对头开始遍历，如果 cur != null，则说明 不是完全二叉树（return false）
     *      如果 cur == null ，则让当前元素出队，若遍历结束还未返回 false，说明 是完全二叉树
     * 3.总结：给树进行层序入队出队的操作，当碰到 null 则跳出循环;
     *         继续对队列进行出队，当剩余所有元素中存在不为 null 的元素--->不是完全二叉树
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){//当队列为空跳出循环
            TreeNode cur = queue.poll();//cur == 队首元素，并且出队
            if(cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        while(!queue.isEmpty()){//当队列为空跳出循环
            TreeNode cur = queue.peek();//cur == 队首元素
            if(cur != null){
                return false;
            }else{
                queue.poll();
            }
        }
        return true;
    }



    //构建一个二叉树( 根据字符串来构造--> ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树)
    //前序遍历
    //需要一个全局变量的 i 来参与运算
    public int i = 0;
    public TreeNode buildTree(String str){
        TreeNode root = null;
        if(str.charAt(i) != '#'){//取字符串中第 i 号下表的字符
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
     * case 1:如果p ，q 在树上的同一侧===》则先被遍历到的 为最近公共祖先
     * case 2:如果p ，q 在树上的不同侧==》则 root 为最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p || root == q){//如果 找到 p或者q则返回
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);//先去左边找
        TreeNode rightTree = lowestCommonAncestor(root.right,p,q);//然后去右边找
        //如果左边 != null,右边 != null，则 root 为最近公共最先
        if(leftTree != null && rightTree != null){
            return root;
        }
        if(leftTree != null){//如果右树为空，则 leftTree 为最近公共最先
            return leftTree;
        }
        if(rightTree != null){//如果左树为空，则 rightTree 为最近公共最先
            return  rightTree;
        }
        return null;
    }





    //二叉树搜索树转换成排序双向链表（二叉搜索树--->根节点的左比根小，右比根大）
    //返回的是双向链表的头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        //这个函数，执行完成后，二叉搜索树的结构已经被改变了
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;//pRootOfTree 为二叉树的根
        //一路向左
        while (head != null && head.left != null) {//由根一直往左遍历，则可以找到链表的头节点
            head = head.left;
        }
        return head;
    }
        //用来改变二叉树的结构
        //中序遍历
        //prev 始终跟着 cur 走，比 cur 慢一步
        public TreeNode prev = null;
        public void ConvertChild(TreeNode pCur) {
            if(pCur == null) {
                return;
            }
            ConvertChild(pCur.left);
            pCur.left = prev;//left ==>作为双向链表的前驱
            if(prev != null) {//这是针对第一次 prev == null 的情况的处理
                prev.right = pCur;//right ==》作为双向链表的后驱
            }
            prev = pCur;//prev 跟着 pCur 走
            ConvertChild(pCur.right);
        }

    //根据一棵树的前序遍历与中序遍历构造二叉树。
    /**
     *前序遍历中的元素为root，在中序遍历中 root 的左边为 root 的左树，root 的右边为 root 的右树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(char[] preorder ,char[] inorder){
        if(preorder == null || inorder == null){//有一个为空则返回 null
            return null;
        }
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
    public int preIndex = 0;

        //用来构造二叉树的
        public TreeNode buildTreeChild(char[] preorder,char[] inorder,
                                       int inbegin,int inend){
            //判断是否有左树或者右树
            if(inbegin > inend){
                return null;
            }
            //保存前序遍历数组中的 preIndex 号下标的元素
            TreeNode root = new TreeNode(preorder[preIndex]);

            //找前序遍历中 preIndex 号下标的元素在中序遍历中的位置 rootIndex
            int rootIndex = findIndexOfInorder(inorder,inbegin,inend,preorder[preIndex]);

            preIndex++;
            //root的左树就是在中序遍历中 root 左边的元素
            root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
            //root的右树就是在中序遍历中 root 右边的元素
            root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);

            return root;


        }
        //找前序遍历中的元素在中序遍历中的位置
        public int findIndexOfInorder(char[] inorder,int inbegin,int inend ,char val){
            for(int i = inbegin ; i <= inend;i++){
                if(inorder[i] == val){
                    return i;
                }
            }
            return -1;//没找到
        }

    // 根据一棵树的中序遍历与后序遍历构造二叉树
    //postIndex == postorder.length-1,从postIndex开始遍历后序
    /**
     * 从最后一个元素开始遍历后序遍历
     * 后序遍历中的元素为root，在中序遍历中 root 的左边为 root 的左树，root 的右边为 root 的右树
     * 在构造树的时候需要先建右树后建左树
     */
    public int postIndex = 0;
    public TreeNode buildTree2(char[] inorder, char[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        postIndex = postorder.length-1;
        return buildTreeChild2(postorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildTreeChild2(char[] inorder, char[] postorder,int inbegin,int inend) {
        if(inbegin > inend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int rootIndex = findIndexOfInorder(inorder,inbegin,inend,postorder[postIndex]);
        postIndex--;
        //先右 后 左
        root.right = buildTreeChild2(inorder,postorder,rootIndex+1,inend);
        root.left = buildTreeChild2(inorder,postorder,inbegin,rootIndex-1);
        return root;
    }





    // 二叉树创建字符串---》将一个二叉树转换成一个字符串

    /**
     *
     * @param t
     * @param sb
     */
    public void tree2strChild(TreeNode t,StringBuilder sb){
        if(t == null){
            return;
        }
        sb.append(t.value);//拼接二叉树的值
        if(t.left == null){//对于左树为空的处理（分右树为空，右树不为空）
            if(t.right == null){
                return;
            }else{
                sb.append("()");
            }
        }else{//左树不为空
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }

        if(t.right == null){//对于右树为空的处理
            return;
        }else{//对于右树不为空
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

