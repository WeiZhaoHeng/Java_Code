import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 20:05
 */
public class TestWork {
    //括号匹配问题
    public static boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < array.length;i++){
            if(array[i] == '('||array[i] =='{'||array[i] == '['){
                stack.push(array[i]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char tmp = stack.peek();
                    if(array[i] == ')' && tmp == '('
                            ||array[i] == '}' && tmp == '{'
                            ||array[i] == ']' && tmp == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str1 = "[[[]]]";
        String str2 = "({[]})";
        String str3 = "[[[[";
        System.out.println(isValid(str1));
        System.out.println(isValid(str2));
        System.out.println(isValid(str3));
    }
}
