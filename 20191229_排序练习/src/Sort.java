import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/29
 * Time: 18:41
 */
public class Sort {
    private int[] array;
    public Sort(int[] array) {
        this.array = array;
    }

    //堆排序
    public void heapSort(){
        createHeap();
        int end = array.length-1;
        while(end > 0){
            int tmp = array[end];
            array[end] = array[0];
            array[0] = tmp;
            adjustDown(0,end);
            end--;
        }
    }
    private void createHeap(){
        for(int i = (array.length-1-1)/2;i >= 0;i--){
            adjustDown(i,array.length);
        }
    }
    private void adjustDown(int root,int len){
        int parent = root;
        int child = 2*parent+1;
        while(child < len){
            if(child+1 < len && array[child] < array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }


    //插入排序
    public void insertSort(){
       int j = 0;
       for(int i = 1;i < array.length;i++){
           int tmp = array[i];
           for( j = i-1;j >= 0;j--){
               if(array[j] > tmp){
                   array[j+1] = array[j];
               }else{
                   break;
               }
           }
           array[j+1] = tmp;
       }
    }

    //希尔排序
    public void shellSort(){
        int[] drr = {4,1};
        for(int i = 0;i < drr.length;i++){
            shell(drr[i]);
        }
    }
    private void shell(int gap){
        int j = 0;
        for(int i = gap;i < array.length;i++){
            int tmp = array[i];
            for(j = i - gap;j >= 0;j -= gap){
                if(array[j] >tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }


    //选择排序
    public void selectSort(){
        for(int i = 0;i < array.length;i++){
            for(int j = i+1;j < array.length;j++){
                if(array[j] < array[i]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }


    //冒泡排序
    public void bubbleSort(){
        boolean flg = false;
        for(int i = 0;i < array.length-1;i++){
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                    flg = true;
                }
            }
            if(!flg){
                break;
            }
        }
    }


    //快速排序
    public void quickSort(){
        quick(0,array.length-1);
    }

    private void quick(int low,int high){
        int pivot = partion(low,high);
        Stack<Integer> stack = new Stack<>();
        if(pivot > low+1 ){
            stack.push(low);
            stack.push(pivot-1);
        }
        if(pivot < high-1){
            stack.push(pivot+1);
            stack.push(high);
        }
        while(!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            pivot = partion(low,high);
            if(pivot > low+1 ){
                stack.push(low);
                stack.push(pivot-1);
            }
            if(pivot < high-1){
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }
    private   int partion(int start,int end){
        int tmp = array[start];
        while(start < end){
            while((start < end) && (array[end] >= tmp)){
                end--;
            }
            if(start >= end){
                break;
            }else {
                array[start] = array[end];
            }


            while((start < end) && (array[start] <= tmp)){
                start++;
            }
            if(start >= end){
                break;
            }else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }


    public void display(){
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
