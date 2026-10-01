package view;

import models.Book;

import java.util.List;

public interface BookView {
    String getAuthor();
    String getTitle();
    String getYear();
    String getAdditionalInfo();
    void clearInput();
    void showBooks(List<Book> notes);
    void showError(String message);
}
