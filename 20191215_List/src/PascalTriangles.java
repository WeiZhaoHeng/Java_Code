import com.sun.javafx.collections.ListListenerHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 14:17
 */
public class PascalTriangles {
    //杨辉三角
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();//构造一个二维列表
        if(numRows == 0){//如果输入的行数为 0 则输出一个空的列表
            return triangle;
        }
        triangle.add(new ArrayList<>());//二位列表第一行
        triangle.get(0).add(1);//给第一行先放一个 1
        //创建其它 行 并且赋值
        for(int i =1;i < numRows;i++){
            List<Integer> curRow = new ArrayList<>();//创建一个新行
            curRow.add(1);//让第一个元素为 1
            List<Integer> prevRow = triangle.get(i-1);//取当前行的上一行用prevRow表示

            //为剩下位置赋值
            for(int j =1;j < i;j++){
                int tmp = prevRow.get(j-1)+prevRow.get(j);
                curRow.add(tmp);
            }
            curRow.add(1);//给该行的最后一个位置赋值为 1
            triangle.add(curRow);//将改行放入二维列表中
        }
        return triangle;

    }
    public static void main1(String[] args) {
        List<List<Integer>> list = generate(6);
        for (List<Integer> ret:list) {
            System.out.println(ret);
        }
    }
}
