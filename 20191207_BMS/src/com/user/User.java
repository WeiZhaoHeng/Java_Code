package com.user;

import com.book.BookList;
import com.operation.IOperation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/7
 * Time: 13:10
 */
public abstract class User {
    public String name;
    //IOperation -->实现了这个接口的类都可以存放进去
    public IOperation[] operations;

    //用户根据选项执行操作
    public void doOperation(int choice, BookList bookList){
        operations[choice].work(bookList);
    }
    public abstract int menu();
}
