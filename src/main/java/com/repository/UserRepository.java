package com.repository;

import com.entity.Book;
import com.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    @Query(value = "SELECT b FROM User b WHERE b.userName=:user_name ")
    public List<User> find(@Param("user_name") String userName);

}
