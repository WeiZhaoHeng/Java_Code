/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/15
 * Time: 11:13
 */
public class Day1 {

    //将一个字符串中的大写转小写
    public static String toLowerCase(String str) {
        char[] array = str.toCharArray();
        for(int i = 0; i < array.length;i++){
            if(array[i] >=65 && array[i] <= 90){
                array[i] += 32;
            }
        }
        return new String(array);
    }

    //给定一个数组，将数组中的元素向右移动 K 的位置
    private static int[] rotateChild(int[] nums,int i,int j){
        while( i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }
    public void rotate(int[] nums, int k) {
        k %= nums.length;//
        rotateChild(nums,0,nums.length-1);
        rotateChild(nums,0,k-1);
        rotateChild(nums,k,nums.length-1);
    }
}
