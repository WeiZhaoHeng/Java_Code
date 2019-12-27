import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/25
 * Time: 16:20
 */
public class Test {




    public static void main1(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildTree();
        System.out.println(binaryTree.getKLevelSize(root,1));
    }
}
