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