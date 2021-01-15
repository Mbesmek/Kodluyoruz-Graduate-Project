package com.controller;

import com.entity.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.service.model.BookContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class webServiceController {

    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping(value = "/book/list",method = RequestMethod.GET)
    public List<Book> getAllBook(){
        List<Book> book=bookService.getAllBook();
        return book;
    }

    @RequestMapping(value = "/book/list/{id}",method = RequestMethod.GET)
    public Book findByBookId(@PathVariable("id") Long id){
        return bookService.findBookWithId(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody BookContext context) {

        return bookService.saveBook(context);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    private String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "Succes";
    }
}
