package services;

import models.Book;

import java.util.List;

public interface BookRepository {
    void save(Book book);
    List<Book> findAll();
}
