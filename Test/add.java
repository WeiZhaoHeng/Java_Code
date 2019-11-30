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