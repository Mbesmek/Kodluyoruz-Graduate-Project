package com.repository;

import com.entity.Author;
import com.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
    @Query(value="SELECT a FROM Author a Where a.authorId=:author_Id")
    public Author findAuthorWithId(@Param("author_Id") Long authorId);

    @Query(value = "SELECT a FROM Author a")
    public Set<Author> getAllAuthor();

    @Query(value = "SELECT MAX(a.authorId) FROM Author a")
    public Long findMaxAuthId();

    @Query(value = "SELECT b FROM Author b WHERE b.authorSurname=:author_surname ")
    public List<Author> findWithSurname(@Param("author_surname") String authorSurName);
}
