package com.dao;

import com.entity.Author;
import com.entity.Book;
import com.repository.AuthorRepository;
import com.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource({ "classpath:application.properties" })
public class BookRepositoryIT {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @Order(1)
    public void findBookWithId() {
        Long maxId = repository.findMaxBookId();
        Book book = repository.findBookWithId(maxId);
        Assert.assertNotNull(book);
        Assert.assertTrue(book.getBookId() > 0);
    }

    @Test
    @Transactional
    @Rollback(true)
    @Order(2)
    public void saveBook() {
        Book book =new Book();
        Long bookMaxID= repository.findMaxBookId();
        Long authorMaxId=authorRepository.findMaxAuthId();
        book.setBookId(bookMaxID+1);
        book.setBookName("A");
        book.setBookPageCount("200");
        book.setPublishDate("2017");


        Author author=new Author();

        author.setAuthorId(authorMaxId+1);
        author.setAuthorName("Veli");
        author.setAuthorSurname("Ata");
        book.setAuthor(author);
        authorRepository.save(author);
        repository.save(book);
        book = repository.findBookWithId(bookMaxID);
        Assert.assertNotNull(book);
        Assert.assertTrue(book.getBookId()>0);

    }

    @Test
    @Transactional
    @Rollback(false)
    @Order(3)
    public void deleteBook() {

        Long bookMaxID = repository.findMaxBookId();
        Book book = repository.findBookWithId(bookMaxID);

        repository.delete(book);

        book = repository.findBookWithId(bookMaxID);

        Assert.assertNull(book);
    }
}
