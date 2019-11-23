//汉诺塔 ----->太难了
import java.util.Scanner;
public class Hanoi{
    public static void move(char pos1,char pos2){
        System.out.println(pos1+"->"+pos2);//打印的时诺盘子的过程
                                           // （具体的从那个挪到那个）
    }
    public static void hanota(int n,char pos1,char pos2,char pos3){
        if(n==1){
            move(pos1,pos3);//当 n ==1时，直接从A 挪到 C即可
        }else{
            hanota(n-1,pos1,pos3,pos2);//将 n-1个 盘子从 A  通过 C 挪到  B
            move(pos1,pos3);//将最大盘子从 A 挪到 B
            hanota(n-1,pos2,pos1,pos3);//再将n-1个盘子从 B 通过 A 挪到 C
        }
    }
    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int n = sc.nextInt();
        hanota(n,'A','B','C');
    }
}