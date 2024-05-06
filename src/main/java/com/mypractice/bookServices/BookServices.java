package com.mypractice.bookServices;

import com.mypractice.bookEntity.Book;
import com.mypractice.bookRepository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;

//    private static List<Book> list =new ArrayList<>();
//    static {
//        list.add(new Book(1,"Let Us C","yaswant Kanatkar"));
//        list.add(new Book(2,"Operating System","Galvin"));
//        list.add(new Book(3,"Digital Circuit","Floyed"));
//    }
    //get All Books
    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }
    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        try {
           // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            this.bookRepository.findById(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return book;
    }
    //adding the books
    public Book addBook(Book b){
        Book result=bookRepository.save(b);
        return result;
    }
    //delete book
    public void deleteBook(int id){
       bookRepository.deleteById(id);
    }
    //update book
    public void updateBook(Book book, int id) {
        book.setId(id);
        bookRepository.save(book);

    }
}
