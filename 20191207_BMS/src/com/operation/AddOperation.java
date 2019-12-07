package com.operation;

import com.book.Book;
import com.book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/7
 * Time: 13:01
 */
public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("添加书籍");
        System.out.println("请输入书名");
        String name = scan.next();
        System.out.println("请输入作者");
        String author = scan.next();
        System.out.println("请输入价格");
        int price = scan.nextInt();
        System.out.println("请输入类型");
        String type = scan.next();
        Book book = new Book(name,author,price,type);
        int curSize = bookList.getUsedSize();
        bookList.setBooks(curSize,book);
        bookList.setUsedSize(curSize+1);
        System.out.println("添加成功");



    }
}
