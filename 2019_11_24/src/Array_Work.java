import java.util.Arrays;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:关于数组的作业
 * User：WeiZhaoheng
 * Date: 2019/11/24
 * Time: 15:44
 */
public class Array_Work {

    //数组数字排列-->给定一个数组将偶数放在前面，奇数放在后面
    public static void transform(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            while(left<right&&arr[left]%2==0){
                left++;
            }
            while(left<right&&arr[right]%2!=0){
                right--;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,4,7,6,9,8,};
        System.out.println(Arrays.toString(arr));
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }


    //对数组进行逆序操作
    public static void negativeSequence(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
    public static void main6(String[] args) {
        int[] arr = {1,3,5,7,9,2,4,6,8,10};
        System.out.println(Arrays.toString(arr));
        negativeSequence(arr);
        System.out.println(Arrays.toString(arr));

    }



    //查找数组中指定元素-->这是按顺序查找
    public static boolean findKey1(int[] arr,int key){
        for(int i=0;i<arr.length;i++){
            if(key==arr[i]){
                return true;
            }
        }
        return false;
    }
    //查找数组中指定元素-->二分法查找(针对有序数组进行)
    public static boolean findKey2(int[] arr,int key){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(key<arr[mid]){
                right = mid - 1;
            }else if(key > arr[mid]){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }

    //对数组进行排序-->冒泡排序(按照从小到大的顺序)
    //也可以直接用 Arrays.sort(arr);-->系统方法来给数组排序

    public  static int[] sequence(int[] arr){
        for(int i=0;i<arr.length;i++){//需要排序的次数-->有多少个元素就要走几次
            for(int j= arr.length-1;j>i;j--){//从最后一个元素开始遍历
                if(arr[j-1]>arr[j]){//如果比前一个元素小
                    int tmp = arr[j-1];//交换两个位置元素的值，将大的值往后放
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }


    public static void main5(String[] args) {
        int[] arr = {1,3,5,7,9,2,4,6,8,10};
        sequence(arr);//先排序
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找的数：");
        int key = sc.nextInt();
        //findKey1(arr,key);
        findKey2(arr,key);//调用二分查找法
        if(findKey2(arr,key)==true){
            System.out.println("你要找的数字存在");
        }else{
            System.out.println("你要找的数不存在");
        }
    }

    public static double numAvg(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return ((double)sum )/ ((double)arr.length);
    }
    public static void main4(String[] args) {
        int[] arr = {10,20,19,21,10};
        double avg = numAvg(arr);
        System.out.println("该数组的平均值是："+avg);
    }

    //找数组中最大的元素
    public static int findMax(int[] arr){
        //该方法俗称打擂台：假设第一个最大，然后用后面的跟其比较
        int max = arr[0];//将第一个设为最大
        for(int i=1;i<arr.length;i++){//从第二个元素开始遍历
            if(arr[i]>max){//若arr[i]>max
                max = arr[i];//则arr[i]变为最大值，再跟后面的比较
            }
        }
        return max;
    }
    public static void main3(String[] args) {
        int[] arr = {1,3,5,2,4,6,9,10,89};
        int max = findMax(arr);
        System.out.println("max:"+max);
    }
    //写一个方法完成Arrays.copyOf()的功能
    public static int[] copyArray(int[] arr){
        int[] newArr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static void main2(String[] args) {
        //数组的拷贝，使用Arrays.copyOf(int[],int);
        int[] arr = {1,2,3,4,5,6};
        int[]  newArr = copyArray(arr);
        System.out.println("newArr:"+Arrays.toString(newArr));
        /*
        int[] newArr = Arrays.copyOf(arr,arr.length);
        System.out.println("newArr:"+Arrays.toString(newArr));
        */
    }

    //写一个方法完成Arrays.toString()的功能
    public static String Array_to_String(int[] arr){
        String ret = "[";
        for(int i=0;i<arr.length;i++){
            ret += arr[i];
            if(i!=arr.length-1){
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }
    public static void main1(String[] args) {
        //以下程序完成了一个将数组转成字符串的过程
        int [] arr ={1,2,3,4,5,6};//定义数组
        String ret = Array_to_String(arr);
        System.out.println(ret);
        /*
        String newArray = Arrays.toString(arr);//数组转成字符串
        System.out.println(newArray);//输出字符串
        */
    }
}
