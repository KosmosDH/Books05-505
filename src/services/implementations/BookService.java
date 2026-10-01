package services.implementations;

import models.Book;
import services.BookRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) { this.repository = repository;}

    public void addBook(String author,
                        String title,
                        String year,
                        String additionalInfo) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор книги не может быть пустым");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не может быть пустым");
        }
        if (year == null || year.isBlank()) {
            throw new IllegalArgumentException("Год не может быть пустым");
        }

        Book book = new Book(UUID.randomUUID(), author, title, parseYear(year), additionalInfo);
        repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    private int parseYear(String year) {
        int iYear;
        try {
            iYear = Integer.parseInt(year);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Неверно указан формат года издания книги");
        }
        if (iYear < -5000 || iYear > LocalDateTime.now().getYear()) {
            throw new IllegalArgumentException("Неверно указан формат года издания книги");
        }
        return iYear;
    }
}
