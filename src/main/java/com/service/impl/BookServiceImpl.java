package com.service.impl;


import com.annotation.CalculateTime;

import com.entity.Author;
import com.entity.Book;
import com.repository.AuthorRepository;
import com.repository.BookRepository;
import com.service.BookService;
import com.service.model.BookContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @CalculateTime(active = true)
    @Override

    public Book findBookWithId(Long bookId) {
       System.out.println(bookId);
        return bookRepository.findBookWithId(bookId);
    }
    @CalculateTime(active = true)
    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }
    @CalculateTime(active = true)
    @Transactional
    @Override
    public String saveBook(BookContext context) {

            Book book =new Book();
            Long bookMaxID= bookRepository.findMaxBookId();
            Long authorMaxId=authorRepository.findMaxAuthId();
            book.setBookId(bookMaxID+1);
            book.setBookName(context.getBookName());
            book.setBookPageCount(context.getBookPageCount());
            book.setPublishDate(context.getPublishDate());


            Author author=new Author();
            List<Author> au=authorRepository.findWithSurname(context.getAuthorSurname());


            if (au.size()>0&& au.get(0).getAuthorSurname().equals(context.getAuthorSurname())){
                author.setAuthorId(au.get(0).getAuthorId());
            }
            else {
            author.setAuthorId(authorMaxId+1);
            }
            author.setAuthorName(context.getAuthorName());
            author.setAuthorSurname(context.getAuthorSurname());
            book.setAuthor(author);
            authorRepository.save(author);

            bookRepository.save(book);
            return "Succes";
    }
    @CalculateTime(active = true)
    @Transactional
    @Override
    public String deleteBook(Long bookId) {
        try {
            bookRepository.deleteById(bookId);
            return "Succes";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Book> findBookWithName(String bookName) {
        return bookRepository.findBookWithName(bookName);
    }

    @CalculateTime(active = true)
    @Transactional
    @Override
    public String editBook(BookContext context) {
        Long bookId= context.getBookId();
        bookRepository.deleteById(bookId);

        Book book =new Book();

        Long authorMaxId= context.getAuthorId();

        book.setBookId(bookId);
        book.setBookName(context.getBookName());
        book.setBookPageCount(context.getBookPageCount());
        book.setPublishDate(context.getPublishDate());


        Author author=new Author();

        author.setAuthorId(authorMaxId);
        author.setAuthorName(context.getAuthorName());
        author.setAuthorSurname(context.getAuthorSurname());
        book.setAuthor(author);
        authorRepository.save(author);

        bookRepository.save(book);
        return "Succes";
    }
}
