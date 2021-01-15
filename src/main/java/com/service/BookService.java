package com.service;


import com.entity.Book;
import com.service.model.BookContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public Book findBookWithId(Long bookId);

    public List<Book> getAllBook();

    public String saveBook(BookContext book);

    public String deleteBook(Long bookId);

    public List<Book> findBookWithName(String bookName);

    public String editBook(BookContext context);



}
