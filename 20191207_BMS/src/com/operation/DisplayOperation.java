package com.operation;

import com.book.BookList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/7
 * Time: 13:02
 */
public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("显示所有书籍");
        for(int i = 0;i < bookList.getUsedSize();i++){
            System.out.println(bookList.getBook(i));
        }
    }
}
