   
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