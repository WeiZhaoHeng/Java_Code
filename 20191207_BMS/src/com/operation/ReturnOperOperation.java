package com.operation;

import com.book.Book;
import com.book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/7
 * Time: 13:03
 */
public class ReturnOperOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍");
        System.out.println("请输入要归还的书名");
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

        book = bookList.getBook(i);
        if(book.isBorrowed()){
            book.setBorrowed(false);
            System.out.println("此书归还成功");
        }else{
            System.out.println("此处没有被借阅");
        }
    }
}
