
//打印顺序表
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