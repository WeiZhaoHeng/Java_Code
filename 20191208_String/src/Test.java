import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/8
 * Time: 14:31
 */
public class Test{

    //Others
    public static void main(String[] args) {
        String str = "  hai ni hao   ";
        System.out.println(str.length());
        str = str.trim();
        System.out.println(str);
        str = str.toUpperCase();
        System.out.println(str);
        str = str.toLowerCase();
        System.out.println(str);
        System.out.println(str.length());
        String str1 = "mama baba";
        System.out.println(str.concat(str1));

    }

    //拆分
    public static void main5(String[] args) {
        String str = "hai.ni.hao.a";
        String[] ret = str.split("\\.");
        System.out.println(Arrays.toString(ret));
    }
    //替换
    public static void main4(String[] args) {
        String str = "abcdabgabc";
        str = str.replaceFirst("a","*");
        System.out.println(str);
    }

    //查找
    public static void main3(String[] args) {
        String str1 = "Abcde";
        String str2 = "abcde";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.indexOf('c'));
        System.out.println(str1.indexOf('e',2));
        System.out.println(str2.lastIndexOf('e'));
        System.out.println(str2.lastIndexOf('e',2));
        System.out.println(str1.startsWith("abc",0));
        System.out.println(str1.endsWith("de"));
    }


    public static void main2(String[] args) {
        byte[] array1 = {65,66,67,68,69,70};
        String str1 = new String(array1,3,2);
        System.out.println(str1+" ");
        String str2 = "ABCDEF";
        byte[] array2 = str2.getBytes();
        System.out.println(Arrays.toString(array2));
    }

    //判断是否全部由数字组成
    public static boolean fun(String str){
        char[] array = str.toCharArray();
        for(int i = 0;i<array.length;i++){
            if(array[i]<'0'||array[i]>'9'){
                return false;
            }
        }
        return true;
    }
    public static void main1(String[] args) {
        String str = "123456789";
        System.out.println(fun(str));
/*        char[] array = {'q','w','e','r','t','y','u','i','o','p'};
        String str1 = new String(array);
        String str2 = String.valueOf(array,2,4);
        System.out.println(str1+"\n"+str2);
        System.out.println(str1.charAt(3));
        String str3 = "asdfghjkl";
        char[] array2 = str3.toCharArray();
        for (char x:array2) {
            System.out.print(x+" ");
        }*/

    }
}
