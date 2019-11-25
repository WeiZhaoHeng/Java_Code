
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/11/25
 * Time: 15:47
 */
public class classCode {
    /**
     * 二维数组
     * @param args
     */
    public static void main(String[] args) {

    }
    public static void main4(String[] args) {
        //定义一个2行3列数组
        int[][] array = {{1,2,3},{4,5,6}};
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        int[][] array3 = new int[2][3];//没有被初始化
        int[][] array4 = new int[2][];
        int[][] array5 = {{1,2},{4,5,6}};
    }



    /**
     * 可变参数编程
     * @param args
     */
    public static int sum(int... array){
        int ret= 0;
        for (int x:array) {
            ret += x;
        }
        return ret;
    }
    public static void main3(String[] args) {
        int ret = sum(1,2,3,4,5,6);
        System.out.println(ret);
    }

    /**
     *判断数组是否有序(从小到大)
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr){
        for(int i=0;i<arr.length-1;++i){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    /**
     * 冒泡的再优化：当数组有序了之后便停止
     * @param arr
     */
    public static void bubbleSort3(int[] arr){
        boolean result = false;
        for(int i=0;i<arr.length-1;i++){
                result = false;//因为每一趟都可能有序
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    result = true;
                }
            }
            if(!result){
                return;
            }
        }
    }
    /**
     * 优化后的冒泡：县判断是否有序，有序则不排，无序则排序
     * @param arr
     */
    public static void bubbleSort2(int[] arr){
        boolean result = isSorted(arr);
        if(result==false){
            for(int i=0;i<arr.length-1;i++){
                for(int j=0;j<arr.length-1-i;j++){
                    if(arr[j]>arr[j+1]){
                        int tmp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = tmp;
                    }
                }
            }
        }
    }
    /**
     * 给数组进行冒泡排序
     * @param arr
     */
    public static void bubbleSort1(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    public static void main2(String[] args) {
        int[] arr = {2,1,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(arr));
        bubbleSort3(arr);
        System.out.println(Arrays.toString(arr));

    }
    /**
     * 用递归实现二分查找
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr,int key,int left,int right){
        if(left>right){
            return -1;
        }
        int mid = (left+right)>>1;
        if(arr[mid]==key){
            return mid;
        }else if(arr[mid]>key){
            return binarySearch(arr,key,left,mid-1);
        }else{
            return binarySearch(arr,key,mid+1,right);
        }

    }
    public static void main1(String[] args) {
        int[] arr={1,2,3,4,5,6,7} ;
        System.out.println(binarySearch(arr,3,0,arr.length));
    }


}
