/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/16
 * Time: 19:45
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.bulidTree();
        binaryTree.preOrderTraversal(binaryTree.bulidTree());
        System.out.println();
        binaryTree.inOrderTraversal(binaryTree.bulidTree());
        System.out.println();
        binaryTree.postOrderTraversal(binaryTree.bulidTree());
        System.out.println();
        System.out.println(binaryTree.getSize(binaryTree.bulidTree()));
        binaryTree.getsize1(binaryTree.bulidTree());
        System.out.println(BinaryTree.size);
        binaryTree.getLeafSize1(binaryTree.bulidTree());
        System.out.println(BinaryTree.leafSize);
        System.out.println(binaryTree.getLeafSize(binaryTree.bulidTree()));
        System.out.println("===========================================");
        System.out.println(binaryTree.getKLevelSize(binaryTree.bulidTree(),6));
        System.out.println(binaryTree.find(root,'0'));
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
}
