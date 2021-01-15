package com.controller;

import com.entity.Book;
import com.service.impl.BookServiceImpl;
import com.service.model.BookContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/frontend/books")
public class FrontEndBookController {
    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getBooks(Model model){
        List<Book> book=bookService.getAllBook();
        model.addAttribute("book",book);
        return "pages/thyme_books_list";
    }
    //when push save button at list page
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String getBookSavePage( Model model){
        model.addAttribute("context",new BookContext());
        return "pages/thyme_book_save";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String SaveBook(@ModelAttribute BookContext context, Model model){

        bookService.saveBook(context);
        model.addAttribute("book",bookService.getAllBook());

        return "pages/thyme_books_list";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private String deleteBook(@RequestParam Long id,Model model){
        bookService.deleteBook(id);
        model.addAttribute("book",bookService.getAllBook());
        return "/pages/thyme_books_list";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String getEditBookPage( @RequestParam Long id,Model model){
        Book book= bookService.findBookWithId(id);
        model.addAttribute("context",book);
        return "pages/thyme_book_edit";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    private String editBook(@ModelAttribute BookContext context,Model model){
        bookService.editBook(context);
        model.addAttribute("book",bookService.getAllBook());
        return "/pages/thyme_books_list";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String getBookByName(@RequestParam(value = "search", required = false) String name, Model model) {
        model.addAttribute("search", bookService.findBookWithName(name));
        return "pages/search";
    }

}
