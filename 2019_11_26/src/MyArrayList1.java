import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/11/27
 * Time: 18:15
 */
public class MyArrayList1 {
    private int[] elem;
    private int usedSize;
    private final int CAPACITY = 10;
    public MyArrayList1(){
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }

    public void display(){
        for(int i =0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    private boolean isFull(){
        return this.usedSize == this.elem.length;
    }
    public void add(int pos,int data){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);

        }
        if(pos <0||pos>this.usedSize){
            System.out.println("该位置不合法");
        }
        for(int i = this.usedSize-1;i>= pos;i--){
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    public boolean contains(int toFind){
        for(int i =0;i<this.usedSize;i++){
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;

    }

    public int search(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind ==this.elem[i]){
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos){
        if(pos<0||pos>this.usedSize)
            return -1;
        return this.elem[pos];
    }

    public void setPos(int pos,int value){
        if(pos<0||pos>this.usedSize){
            System.out.println("数组越界无法赋值");
        }
        this.elem[pos] = value;
    }

    public void remove(int toRemove){
        int index = search(toRemove);
        if(index ==-1){
            System.out.println("找不到要删除的元素");
            return;
        }
        for(int i =index ;i<this.usedSize-1;i++){
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    public int size(){
        return usedSize;
    }
    public void clear(){
        this.usedSize = 0;
    }



}
