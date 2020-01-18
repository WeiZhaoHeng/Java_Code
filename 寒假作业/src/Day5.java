import java.security.acl.Group;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/18
 * Time: 17:14
 */
public class Day5 {

    //给定一个整数数组，判断是否存在重复元素
    public static boolean containsDuplicate(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length;i++){
            for(int j = i+1;j< nums.length;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count != 0;
    }
    public static boolean containsDuplicate1(int[] nums){
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    //长按键入
    //你的朋友正在使用键盘输入他的名字 name。
    // 偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
    //你将会检查键盘输入的字符 typed。
    // 如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
    public static boolean isLongPressedName(String name, String typed) {
        return true;
    }
    private static int getLength(String str,char ret,int index){
        char[] ch = str.toCharArray();
        int count = 0;
        for(int i = index;i < ch.length;i++){
            if(ch[i] != ret){
                return count;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "aabbccddc";
        boolean bool  = isLongPressedName(str1,str2);
        System.out.println(bool);
    }
}
