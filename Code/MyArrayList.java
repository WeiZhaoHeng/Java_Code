import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/2/18
 * Time: 16:37
 */
public class MyArrayList<T> {

    private T[] elem;//定义一个数组

    private int usedSize;//用来记录数组内元素个数

    private final int CAPACITY = 10;//初始容量

    //简单构造方法
    public MyArrayList(){

        this.elem = (T[])new Object[CAPACITY];
        this.usedSize = 0;

    }

    //打印顺序表
    public void display(){
        if(this.usedSize == 0){
            System.out.println("该顺序表没有元素");
            return;
        }
        for(int i = 0; i < this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    //在 pos 位置新增元素
    public void add(int pos,T data){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        if(pos < 0 || pos > this.usedSize){
            System.out.println("该位置不合法");
            return;
        }
        for(int i = this.usedSize-1;i >= pos;i--){
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        usedSize++;
    }
    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }


    //判断是否包含某个元素
    public boolean contains(T toFind){
        if(this.usedSize == 0){
            System.out.println("没有元素");
            return false;
        }
        for(int i = 0; i < this.usedSize;i++){
            if(toFind == this.elem[i]){
                return true;
            }
        }
        return false;
    }


    //查找某个元素对应的位置
    public int search(T toFind){
        if(this.usedSize == 0){
            System.out.println("没有元素");
            return -1;
        }
        for(int i = 0 ; i < this.usedSize;i++){
            if(toFind == this.elem[i]){
                return i;
            }
        }
        return -1;
    }


    //获取 pos 位置的元素
    public T getPos(int pos){
        if(this.usedSize == 0){
            System.out.println("没有元素");
            return null;
        }
        if(pos < 0 || pos > this.usedSize){
            System.out.println("该位置不合法");
            return null;
        }
        return this.elem[pos];
    }


    //给 pos 位置的元素设为 value
    public void setPos(int pos,T value){
        if(pos < 0 || pos > this.usedSize){
            System.out.println("给位置不合法");
            return ;
        }
        this.elem[pos] = value;
    }


    //删除第一次出现的关键字
    public void remove(T toRemove){
        int index = search(toRemove);
        if(index == -1){
            System.out.println("找不到要删除的元素");
            return;
        }
        for(int i = index;i < this.usedSize-1;i++){
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }


    //获取顺序表的长度
    public int size(){
        return this.usedSize;
    }

    //清空顺序表
    public void clear(){
        this.usedSize =0;
    }


}
