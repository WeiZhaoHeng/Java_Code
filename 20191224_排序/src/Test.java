import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/24
 * Time: 19:15
 */
public class Test {

    //快速排序
    public static void quickSort(int[] array){
        quick2(array,0,array.length-1);
    }
    //递归排序
    public static void quick1(int[] array,int low,int high){
        if(low >= high){
            return;
        }
        int pivot = partion(array,low,high);
        quick1(array,low,pivot-1);
        quick1(array,pivot+1,high);
    }
    //非递归排序
    public static void quick2(int[] array,int low,int high){
        int pivot = partion(array,low,high);
        Stack<Integer> stack = new Stack<>();
        if(pivot > low+1){
            stack.push(low);
            stack.push(pivot-1);
        }
        if(pivot < high-1){
            stack.push(pivot+1);
            stack.push(high);
        }

        while(!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            pivot = partion(array,low,high);
            if(pivot > low+1){
                stack.push(low);
                stack.push(pivot-1);
            }
            if(pivot < high-1){
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }
    public static int partion(int[] array,int start,int end){
        int tmp = array[start];
        while(start < end){
            while((start < end) && (array[end] >= tmp)){
                end--;
            }
            if(start >= end) {
                break;
            }else{
                array[start] = array[end];
            }



            while((start < end) && (array[start] <= tmp)){
                start++;
            }
            if(start >= end){
                break;
            }else{
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }



    //冒泡排序
    public static void bubbleSort(int[] array){
        boolean flg = false;
        for(int i = 0; i < array.length-1;i++){
            for(int j = 0; j < array.length-1-i;j++){
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = array[j];
                    flg = true;
                }
            }
            if(!flg){
                break;
            }
        }
    }



    //选择排序
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1;j < array.length;j++){
                if(array[j] < array[i]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    //希尔排序
    public static void shellSort(int[] array){
        int[] drr = {5,3,1};
        for(int i = 0;i < drr.length;i++){
            shell(array,drr[i]);
        }

    }
    public static void shell(int[] array,int gap){
        int j = 0;
        for(int i = gap;i < array.length;i++){
            int tmp = array[i];
            for( j = i-gap;j >=0 ;j-=gap){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }




    //插入排序
    public static void insertSort(int[] array){
        int j = 0;
        for(int i = 1;i < array.length;i++){
            int tmp = array[i];
            for( j = i-1;j >=0 ;j--){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(10000);
        }
        long time1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        quickSort(array);
        long time2 = System.currentTimeMillis();

        System.out.println(Arrays.toString(array));

        System.out.println(time2-time1);
    }
}
