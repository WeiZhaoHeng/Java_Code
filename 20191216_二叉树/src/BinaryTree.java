import sun.reflect.generics.tree.Tree;

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






}
