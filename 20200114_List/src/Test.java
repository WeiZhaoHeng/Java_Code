import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 9:43
 */
public class Test {
    public static int[] rotateChild(int[] nums,int i,int j){
        while( i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        rotateChild(nums,0,nums.length-1);
        rotateChild(nums,0,k-1);
        rotateChild(nums,k,nums.length-1);
    }
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        rotate(array,4);
        System.out.println(Arrays.toString(array));
    }
    public static String tolowerCase(String str){
        char[] array = str.toCharArray();
        for(int i = 0;i < array.length;i++){
            if(array[i] >=65 && array[i] <= 90){
                array[i] +=32;
            }
        }
        return new String(array);
    }
    public static void mystery(int x){
        System.out.print(x%10);
        if((x/10) !=0){
            mystery(x/10);
        }
        System.out.print(x%10);
    }
    public static void main2(String[] args) {
        String str = "ABCDe";
        String ret = tolowerCase(str);
        System.out.println(ret);
    }

}
