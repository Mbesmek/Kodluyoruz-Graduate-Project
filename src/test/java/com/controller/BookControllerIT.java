package com.controller;

import com.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({ "classpath:application.properties" })
public class BookControllerIT {
    @Autowired
    private TestRestTemplate restTemplate;


    @LocalServerPort
    private int tomcatPortNo;

    @Test
    @Order(1)
    public void testRestTemplate() {

        ResponseEntity<String> response = restTemplate.getForEntity("https://www.google.com", String.class);

        System.out.println(tomcatPortNo);

        Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
        Assert.assertTrue(response.getBody().length() > 0);
    }
    @Test
    @Order(2)
    public void findBookById() {

        String url = prepareBookRestServiceRootUrl() + "book/list/101";

        ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);

        Book book = response.getBody();

        Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
        Assert.assertTrue(101 == book.getBookId());
    }

    private String prepareBookRestServiceRootUrl() {
        return "http://localhost:" + tomcatPortNo + "/book/";
    }

}
