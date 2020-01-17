import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/15
 * Time: 11:13
 */
public class Day2 {

    //给定一个数组 nums 和一个值 val，
    //你需要原地移除所有数值等于 val 的元素
    //返回移除后数组的新长度。
    public static int removeElement(int[] nums, int val) {
        for(int i = 0; i < nums.length;i++){

            while(nums[i] == val && i != nums.length-1) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums = Arrays.copyOf(nums, nums.length - 1);
            }

        }
        if(nums[nums.length -1 ] == val){
            nums = Arrays.copyOf(nums, nums.length - 1);
        }
        return nums.length;
    }

    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    //如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    /**
     * 使用二分查找法
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(target < nums[mid]){
                right = mid-1;
            }else if(target > nums[mid]){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,7,9};
        int a = 0;
        System.out.println(searchInsert(array,a));
    }


}
