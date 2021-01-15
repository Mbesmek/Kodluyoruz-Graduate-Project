package com.service.model;

import java.util.Date;

public class BookContext {
    public BookContext() {
           }

    public BookContext(Long bookId, String bookName, String publishDate, String bookPageCount, String authorName, String authorSurname,Long authorId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publishDate = publishDate;
        this.bookPageCount = bookPageCount;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorId=authorId;
    }

    private Long bookId;
    private String bookName;
    private String publishDate;
    private String bookPageCount;
    private String authorName;
    private String authorSurname;
    private Long authorId;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getBookPageCount() {
        return bookPageCount;
    }

    public void setBookPageCount(String bookPageCount) {
        this.bookPageCount = bookPageCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }
}
