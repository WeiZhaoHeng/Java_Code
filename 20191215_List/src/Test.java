import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 10:19
 */

public class Test {

    //3.删除一个字符串中出现的第二个字符串中的字符
    //	eg：String str1 = "Welcom to Bit";
    //		String str2 = "come";
    //结果： Wl t bit
    public static List<Character> fun(String str1,String str2){
        List<Character> ret = new ArrayList<>();
        for(int i = 0;i < str1.length();i++){
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                ret.add(ch);
            }
        }
        return ret;
    }
    public static void main2(String[] args) {
        String str1 = "Welcom to Bit";
        String str2 = "come";
        List<Character> list = fun(str1,str2);
        System.out.println(list);
    }


    public static void main1(String[] args) {
        List<Students> list = new ArrayList<>();
        list.add(new Students("小明","Java20",89.5));
        list.add(new Students("小李","Java21",90.5));
        list.add(new Students("小黑","Java20",75.5));
        list.add(new Students("小王","Java21",88.5));
        System.out.println(list);
    }
}
