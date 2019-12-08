import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:顺序表
 * User：WeiZhaoheng
 * Date: 2019/11/26
 * Time: 15:44
 */
/*class MyArrayList {
    //属性
    private  int[] elem;
    private  int usedSize;
    private  final int CAPACITY = 10;

    public MyArrayList(){
        this.elem = new int[CAPACITY];
        this.usedSize = 0;

    }

    //方法

    // 打印顺序表
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // 在 pos 位置新增元素
    private boolean isFull(){
        *//*
         if(this.usedSize == this.elem.length){
            return true;
        }
        return false;
        *//*
        return this.usedSize == this.elem.length;
    }

    public void add(int pos, int data) {
        //扩容
        if(isFull()){
            //二倍扩容
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        if(pos<0||pos>this.usedSize){
            System.out.println("给位置不合法");
            return;
        }
        //1.挪数据
        for (int i = this.usedSize-1; i >=pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for(int i=0;i<this.usedSize;i++){
            if(toFind==this.elem[i]){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>this.usedSize)
            return -1;
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos<0||pos>this.usedSize){
            System.out.println("数组越界无法赋值");
            return ;
        }
        this.elem[pos] = value;

    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index =search(toRemove);
        if(index == -1){
            System.out.println("找不到要删除的数字");
            return;
        }
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];

        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {

        return usedSize;
    }
      // 清空顺序表
    public void clear() {
        this.usedSize = 0;

    }*/
class MyArrayList {
    //属性
    private int[] elem;
    private int usedSize;
    private final int CAPACITY = 10;
    public MyArrayList(){
        this.elem = new int[CAPACITY];
        this.usedSize = 0;

    }

    //方法

    // 打印顺序表
    public void display() {
        if(this.usedSize == 0){
            System.out.println("该顺序表没有元素");
            return;
        }
        for(int i=0;i < this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }


    private boolean isFull(){
        /*
         if(this.usedSize == this.elem.length){
            return true;
        }
        return false;
        */
        return this.usedSize == this.elem.length;
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        if(pos<0||pos>this.usedSize){
            System.out.println("该位置不合法");
            return ;
        }
        for(int i = this.usedSize-1;i>=pos;i--){
            this.elem[i+1] = this.elem[i];

        }
        this.elem[pos] = data;
        usedSize++;


    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if(this.usedSize == 0){
            System.out.println("该顺序表没有元素");
            return false;
        }
        for(int i = 0;i<this.usedSize;i++){
            if(toFind == this.elem[i]){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(this.usedSize == 0){
            System.out.println("该顺序表没有元素");
            return -1;
        }
        for(int i=0;i<this.usedSize;i++){
            if(toFind == this.elem[i]){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(this.usedSize == 0){
            System.out.println("该顺序表中没有元素");
            return -1;
        }
        if(pos<0||pos>this.usedSize){
            System.out.println("该位置不合法");
            return -1;
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos<0||pos>this.usedSize){
            System.out.println("该位置不合法");
            return ;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key


    public void remove(int toRemove) {
        int index = search(toRemove);
        if(index == -1){
            System.out.println("找不到要删除的元素");
            return ;
        }
        for( int i =index;i < this.usedSize-1;i++){
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;

    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;

    }


}
