import Controllers.BookController;
import Services.BookRepository;
import Services.Implementations.BookService;
import Services.Implementations.InMemoryBookRepository;
import View.Window;

void main() {
    BookRepository repository = new InMemoryBookRepository();
    var service = new BookService(repository);
    var controller = new BookController(service);

    var wnd = new Window(controller);
    controller.attachView(wnd);

    wnd.setVisible(true);
}