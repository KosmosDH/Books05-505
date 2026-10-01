package Controllers;

import Services.Implementations.BookService;
import View.BookView;

public class BookController {
    private final BookService service;
    private BookView view;

    public BookController(BookService service){
        this.service = service;
    }

    public void attachView(BookView view){
        this.view = view;
    }

    public void addBookClicked(){
        try {
            var author = view.getAuthor();
            var year = view.getYear();
            var title = view.getTitle();
            var additionals = view.getAdditionalInfo();
            service.addBook(author,title,year,additionals);
            view.clearInput();
            view.showBooks(service.getAllBooks());
        } catch (IllegalArgumentException ex){
            view.showError(ex.getMessage());
        }
    }
}
