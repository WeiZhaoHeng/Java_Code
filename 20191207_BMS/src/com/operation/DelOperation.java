package com.operation;

import com.book.Book;
import com.book.BookList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/7
 * Time: 13:02
 */
public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        System.out.println("请输入要删除的书名：");
        String name = scan.next();
        int i = 0;
        Book book = null;
        for(;i< bookList.getUsedSize();i++){
            book = bookList.getBook(i);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(i == bookList.getUsedSize()){
            System.out.println("没有此书");
            return ;
        }

        for(int j = i;j < bookList.getUsedSize()-1;j++){
            book = bookList.getBook(j+1);
            bookList.setBooks(j,book);
        }
        int curSize = bookList.getUsedSize();
        bookList.setUsedSize(curSize-1);
        System.out.println("删除成功！");
    }
}
