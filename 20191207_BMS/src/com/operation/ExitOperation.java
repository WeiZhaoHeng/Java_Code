package com.operation;

import com.book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/7
 * Time: 13:03
 */
public class ExitOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(1);
    }
}
