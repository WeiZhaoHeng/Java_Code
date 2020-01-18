import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/17
 * Time: 20:08
 */
public class Day3 {

    public static void main3(String[] args) {
        int i = 2;
        int ret = 0;
        switch (i){
            case 1:
                ret = ret + i;
            case 2:
                ret = ret + i*2;
            case 3:
                ret = ret + i*3;
                default:
                    ret = ret +5;
        }
        System.out.println(ret);
    }

    //给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
    // 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
    /**
     * 对ransom进行单个遍历，判断判断是否在magazine中包含。
     * 如果包含则删除magazin中的元素
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        for(int i = 0;i < ransomNote.length();i++){
            char tmp = ransomNote.charAt(i);
            if(magazine.contains(tmp+"")){
                int index = magazine.indexOf(tmp);
                magazine = removeStr(magazine,index);
            }else{
                return false;
            }
        }
        return true;
    }
    private static String removeStr(String magazine ,int index){
        char[] ch = magazine.toCharArray();
        for (int i = index ;i < ch.length - 1;i++){
            ch[i] = ch[i+1];
        }
         ch = Arrays.copyOf(ch,ch.length-1);
        return String.copyValueOf(ch);
    }

    public static void main2(String[] args) {
        String str1 = "aaaaa";
        String str2 = "aab";
        boolean bool = canConstruct(str1,str2);
        System.out.println(bool);
    }


    //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
    //转字符串解
    public static boolean isPalindrome1(int x) {
        if(x >=0 && x <= 9){
            return true;
        }
        String str = String.valueOf(x);
        int start = 0;
        int end = str.length()-1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalindrome1_1(int x){
        return String.valueOf(x).equals(new StringBuilder(String.valueOf(x)).reverse().toString());
    }

    //依据数字求解
    public static boolean isPalindrome2(int x){
        if(x < 0){
            return false;
        }
        int div = 1;
        while( x/div >= 10){
            div = div * 10;
        }
        while(x > 0){
            int left = x / div;
            int right = x % 10;
            if(left != right){
                return false;
            }
            x = (x % div) / 10;
            div = div / 100;
        }
        return true;
    }



    public static void main1(String[] args) {
        int x = 123456321;
        boolean bool = isPalindrome2(x);
        System.out.println(bool);
    }

}
