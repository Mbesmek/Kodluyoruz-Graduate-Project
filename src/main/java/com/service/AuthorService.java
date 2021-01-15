package com.service;

import com.entity.Author;
import org.springframework.stereotype.Service;


import java.util.Set;
@Service
public interface AuthorService {

    public Author findAuthorWithId(Long authorId);

    public Set<Author> getAllAuthor();

    public String saveAuth(Author author);

    public String deleteAuth(Long authorId);
}
