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