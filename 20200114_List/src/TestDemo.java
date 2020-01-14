import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 11:12
 */
public class TestDemo {
    //杨辉三角
    public static void main3(String[] args) {
        List<List<Integer>> list = generate(6);
        for(List<Integer> ret:list){
            System.out.println(ret);
        }
    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> tringle = new ArrayList<>();
        if(numRows == 0){
            return tringle;
        }
        tringle.add(new ArrayList<>());
        tringle.get(0).add(1);
        for(int i = 1;i < numRows;i++){
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            List<Integer> prevRow = tringle.get(i-1);
            for(int j = 1;j < i;j++){
                int tmp = prevRow.get(j-1)+prevRow.get(j);
                curRow.add(tmp);
            }
            curRow.add(1);
            tringle.add(curRow);
        }
        return tringle;
    }
    public static String trans(String str1,String str2){
        List<Character> ret = new ArrayList<>();
        for(int i = 0 ; i< str1.length();i++){
            char tmp = str1.charAt(i);
            if(!str2.contains(tmp+"")) {
                ret.add(str1.charAt(i));
            }
        }
        return ret.toString();
    }

    public static void main2(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        String ret = trans(str1,str2);
        System.out.println(ret);
    }
    public static void main1(String[] args) {
        List<Students> list = new ArrayList<>();
        list.add(new Students("啊飞","2班",98.1));
        list.add(new Students("啊黑","1班",95.1));
        list.add(new Students("啊王","2班",90.1));
        list.add(new Students("啊刘","1班",99.1));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
