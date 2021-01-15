package com.service.impl;


import com.annotation.CalculateTime;

import com.entity.Author;
import com.repository.AuthorRepository;
import com.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @CalculateTime(active = true)
    @Override
    public Author findAuthorWithId(Long authorId) {
        return authorRepository.findAuthorWithId(authorId);
    }

    @Override
    public Set<Author> getAllAuthor() {
        return authorRepository.getAllAuthor();
    }
    @CalculateTime(active = true)
    @Transactional
    @Override
    public String saveAuth(Author author) {
        try {
            authorRepository.save(author);
            return "Succes";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
    @CalculateTime(active = true)
    @Transactional
    @Override
    public String deleteAuth(Long authorId) {
   try {
       authorRepository.deleteById(authorId);
       return "Succes" ;
   }catch (Exception e){
       return e.getMessage();
   }

    }
}
