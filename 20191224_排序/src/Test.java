import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/24
 * Time: 19:15
 */
public class Test {



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
        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(10000);
        }
        long time1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        selectSort(array);
        long time2 = System.currentTimeMillis();

        System.out.println(Arrays.toString(array));

        System.out.println(time2-time1);
    }
}
