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


    //将字符串进行逆置
    public static String reverse(String str) {
        char[] array = str.toCharArray();
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(array);
    }

    //将 I am student --> student am I
    //1.先按照" "拆分成多个子字符串
    //2.将每一个子字符串逆置
    //3.然后连接再逆置
    public static String fun2(String str){
        String[] ret = str.split(" ");
        for(int i = 0;i < ret.length;i++){
            ret[i] = reverse(ret[i]);
        }
        StringBuilder newStr = new StringBuilder();
        for(int i = 0;i < ret.length;i++){
            if(i == ret.length-1){
                //newStr = newStr+ret[i];
                newStr.append(ret[i]);
            }else{
                // newStr = newStr+ret[i]+" ";
                newStr.append(ret[i]).append(" ");
            }
        }
        String rev = newStr.toString();
        return rev = reverse(rev);
    }
    public static void main3(String[] args) {
        System.out.println("请输入一句话：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str  = fun2(str);
        System.out.println(str);
    }


    //字符串压缩-->aabbccddeeaa===>2a2b2c2d2e2a
    public static String fun3(String str){
        if(str == null || str.length() <= 0) {
            return null;
        }
        char ch = str.charAt(0);//a
        int repCount = 1;//重复出现的次数
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == ch) {
                repCount++;
            }else {
                sb.append(repCount).append(ch);//2a
                //i->
                ch = str.charAt(i);//b
                repCount = 1;
            }
        }
        return sb.append(repCount).append(ch).toString();
    }
    //aabbccddee
    public static String fun4(String str){
        char[] array = str.toCharArray();
        int a= array.length;
        int count = 1;
        StringBuilder newStr = new StringBuilder();
        String newStr2 = new String();
        int i = 0;
        for(;i < a ;i++){
            if(array[i] == array[i+1]){
                count =1;
                while(array[i] == array[i+1]){
                    count++;
                    i++;
                    if(i == a-1){
                        //newStr = newStr+count+array[i];
                        newStr.append(count).append(array[i]);
                        newStr2 = newStr.toString();
                        return newStr2;
                    }
                }
            }
            //newStr = newStr+count+array[i];
            newStr.append(count).append(array[i]);
        }
        newStr2 = newStr.toString();
        return newStr2;
    }
    public static void main(String[] args) {
        String str = "aabbccdddaaa";
        str = fun4(str);
        System.out.println(str);
    }




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
