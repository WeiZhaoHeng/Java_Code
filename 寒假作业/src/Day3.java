/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/17
 * Time: 20:08
 */
public class Day3 {
    public static void main(String[] args) {
        int i = 2;
        int ret = 0;
        switch (i){
            case 1:
                ret = ret + i;
            case 2:
                ret = ret + i*2;
            case 3:
                ret = ret + i*3;
        }
        System.out.println(ret);
    }

    //给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
    // 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
    public boolean canConstruct(String ransomNote, String magazine) {
        
    }

}
