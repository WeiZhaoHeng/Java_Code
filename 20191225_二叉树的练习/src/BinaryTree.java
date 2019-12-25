import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/25
 * Time: 16:20
 */

class TreeNode{
    char value;
    TreeNode left;
    TreeNode right;
    public TreeNode(char value){
        this.value = value;
    }
}

public class BinaryTree {
    public TreeNode buildTree(){
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
    public void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    //中序遍历
    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+ " ");
        inOrderTraversal(root.right);
    }

    //后序遍历
    public void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.println(root.value+" ");
    }

    //计算节点的个数
    public static  int size = 0;
    public void getsize1(TreeNode root){
        if(root == null){
            return;
        }
        size++;
        getsize1(root.left);
        getsize1(root.right);

    }

    public int getSize(TreeNode root){
        if(root == null){
            return 0;
        }
        return getSize(root.left)+getSize(root.right)+1;
    }

    //求叶子节点的个数
    public static int leafSize = 0;
    public void getLeafSize1(TreeNode root){
        if(root == null){
            return;
        }else if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    public int getLeafSize(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right ==null){
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.right);
    }

    //求底K 层结点的个数
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

    public TreeNode find(TreeNode root,char val){
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
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p == null && q!= null || p != null && q == null){
            return false;
        }
        if(p == null && q == null){
            return true;
        }
        if(p.value != q.value){
            return false;
        }
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
    public boolean isSubTree(TreeNode s,TreeNode t){
        if(s == null || t == null){
            return false;

        }
        if(isSameTree(s,t)){
            return true;
        }
        if(isSubTree(s.left,t)){
            return true;
        }
        if(isSubTree(s.right,t)){
            return true;
        }
        return false;
    }

    //求二叉树的深度
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftD  = maxDepth(root.left);
        int rightD = maxDepth(root.right);
        return leftD>rightD?leftD+1:rightD+1;
    }

    //平衡二叉树
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;

        }
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);
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
    public boolean isSymmetris(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetrisChild(root.left, root.right);
    }
    public boolean isSymmetrisChild(TreeNode leftTree,TreeNode rightTree){
        if(leftTree != null && rightTree == null || leftTree == null && rightTree != null){
            return false;
        }
        if(leftTree == null && rightTree == null){
            return true;
        }
        return leftTree.value == rightTree.value
                && isSymmetrisChild(leftTree.left,rightTree.right)
                && isSymmetrisChild(leftTree.right, rightTree.left);
    }

    //前中后序的非递归

    //前序
    public void preOrderTraversalNor(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while( cur != null){
                stack.push(cur);
                System.out.print(cur.value+" ");
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    //中序
    public void inOrderTraversalNor(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.value+" ");
            cur = cur.right;
        }
    }

    //后序
    public void postOrderTraversalNor(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null || !stack.empty()){
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
    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.value+" ");
            if(cur.left != null){
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
                System.out.print(cur.value+" ");
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


    //判断是否时完全二叉树
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

    //构建一个二叉树( 根据字符串来构造--> ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树)
    //前序遍历
    //需要一个全局变量的 i 来参与运算
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

    public TreeNode  lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return root;
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
            return rightTree;
        }
        return null;
    }

    //二叉树搜索树转换成排序双向链表（二叉搜索树--->根节点的左比根小，右比根大）
    //返回的是双向链表的头结点
    public TreeNode Convert(TreeNode pRootOfTree){
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while(head != null && head.left != null){
            head = head.left;
        }
        return head;
    }
    public TreeNode prev = null;
    public void ConvertChild(TreeNode pCur){
        if(pCur == null){
            return;
        }
        ConvertChild(pCur.left);
        pCur.left = prev;
        if(prev != null){
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }

    //根据一棵树的前序遍历与中序遍历构造二叉树。
    public TreeNode buildTree(char[] preorder,char[] inorder){
        if(preorder == null || inorder == null){
            return null;
        }
        if(preorder.length == 0|| inorder.length == 0){
            return null;
        }
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }

    public int preIndex = 0;
    public TreeNode buildTreeChild(char[] preorder,char[] inorder,
                                   int inbegin,int inend){
        if(inbegin > inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndex = findIndexOfInorder(inorder,inbegin,inend,preorder[preIndex]);
        preIndex++;
        root.left =  buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);
        return root;
    }
    public int findIndexOfInorder(char[] inorder,int inbegin,int inend ,char val){
        for(int i = inbegin;i <=inend;i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }


    // 根据一棵树的中序遍历与后序遍历构造二叉树
    public int postIndex = 0;
    public TreeNode buildTree2(char[] inorder,char[] postorder){
        if(inorder == null || postorder == null){
            return null;
        }
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        postIndex = postorder.length-1;
        return buildTreeChild2(postorder,inorder,0,inorder.length-1);
    }

    public TreeNode buildTreeChild2(char[] inorder, char[] postorder,int inbegin,int inend){
        if(inbegin > inend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int rootIndex = findIndexOfInorder(inorder,inbegin,inend,postorder[postIndex]);

        root.right = buildTreeChild2(inorder,postorder,rootIndex+1,inend);
        root.left = buildTreeChild2(inorder,postorder,inbegin,rootIndex-1);
        return root;
    }

    // 二叉树创建字符串---》将一个二叉树转换成一个字符串

    public String tree2str(TreeNode t){
        StringBuilder sb = new StringBuilder();
        tree2strChild(t,sb);
        return sb.toString();
    }
    public void tree2strChild(TreeNode t,StringBuilder sb){
        if(t == null){
            return ;
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
            tree2strChild(t.right,sb);
            sb.append(")");
        }

        if(t.right == null){
            return ;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }
    }


}
