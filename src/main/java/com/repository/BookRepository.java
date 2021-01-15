package com.repository;

import com.entity.Author;
import com.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    @Query(value = "SELECT b FROM Book b WHERE b.bookId=:book_Id ")
    public Book findBookWithId(@Param("book_Id") Long bookId);

    @Query(value = "SELECT e FROM Book e")
    public List<Book> getAllBook();

    @Query(value = "SELECT MAX(e.bookId) FROM Book e")
    public Long findMaxBookId();

    @Query(value = "SELECT b FROM Book b WHERE b.bookName=:book_name ")
    public List<Book> findBookWithName(@Param("book_name") String bookName);

    @Query(value = "SELECT b FROM Book b WHERE b.bookId=:author_id")
    public Long findAuthorId(@Param("author_id") Long bookId);

}
