import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/9
 * Time: 19:38
 */
public class Test {

    //合并两个数组并输出有序数组
    public static int[] fun1(int[] arr1,int[] arr2){
        int a = arr1.length+arr2.length;
        int[] arr3 = new int[a];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i != arr1.length&&j != arr2.length){
            if(arr1[i] < arr2[j]){
                arr3[k] = arr1[i];
                i++;
            }else{
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        if(i == arr1.length){
            for(;k < a;k++){
                arr3[k] = arr2[j];
                j++;
            }
        }
        if(j == arr2.length){
            for(;k < a;k++){
                arr3[k] = arr1[i];
                i++;
            }
        }
        return arr3;
    }
    public static void main1(String[] args) {
        int[] array1 = {4,5,6};
        int[] array2 = {1,2,3};
        Arrays.sort(array1);
        Arrays.sort(array2);
        int[] ret = fun1(array1,array2);
        System.out.println(Arrays.toString(ret));
    }
}
