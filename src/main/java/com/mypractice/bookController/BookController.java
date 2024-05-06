package com.mypractice.bookController;
import com.mypractice.bookEntity.Book;
import com.mypractice.bookServices.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookServices bookServices;
    //get all book
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){

        List<Book> list=bookServices.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    //get books by id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book book= bookServices.getBookById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }
    //adding the book
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
       Book b = this.bookServices.addBook(book);
        System.out.println(book);
        return b;
    }
    //get Delete
    @DeleteMapping("/books/{id}")
    public void deteteBook(@PathVariable("id") int id){
        this.bookServices.deleteBook(id);
    }
    //update book
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book,@PathVariable("id") int id){
        this.bookServices.updateBook(book,id);
        return book;
    }

}
