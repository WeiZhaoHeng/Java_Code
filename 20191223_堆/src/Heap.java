import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/23
 * Time: 22:18
 */
public class Heap {
    public int[] elem ;
    public int usedSize;
    public Heap(){
        this.elem = new int[10];
        this.usedSize = 0;
    }
    public void AdjustDown(int root,int len){
        int parent = root;
        int child = 2*parent+1;
        //判断是否有孩子
        while(child < len){
            if(child+1 < len &&this.elem[child] < this.elem[child+1]){
                child = child+1;
            }

            //child是左右孩子中最大值的下标
            if(this.elem[child] > this.elem[parent]){
                //交换
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }


    public void creatHeap(int[] array){
        for(int i =0;i < array.length;i++){
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for(int i = (this.usedSize-1-1)/2;i >=0;i--){
            AdjustDown(i,this.usedSize);
        }
    }


    public void show(){
        for(int i =0;i < this.usedSize ;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    public void AdjustUp(int child){
        int parent = (child-1)/2;
        while(child > 0){
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }


    public void pushHead(int val){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);

        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
        AdjustUp(this.usedSize-1);
    }




    public boolean isEmpty(){
        return this.usedSize == 0;
    }


    public void popHeap(){
        if(isEmpty()){
            return;
        }
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;
        AdjustDown(0,this.usedSize);
    }


    public int getHeapTop(){
        if(isEmpty()){
            return -1;
        }
        return this.elem[0];
    }



    public void heapSort(){
        int end = this.usedSize-1;
        while(end > 0){
            int tmp = this.elem[end];
            this.elem[end] = this.elem[0];
            this.elem[0] = tmp;
            AdjustDown(0,end);
            end--;
        }
    }
}
