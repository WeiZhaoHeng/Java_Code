import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/29
 * Time: 18:41
 */
public class Test {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for(int i = 0; i< array.length;i++){
            array[i] = random.nextInt(100);
        }
        Arrays.sort(array);

    }
}
