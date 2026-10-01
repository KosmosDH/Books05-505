import controllers.BookController;
import services.BookRepository;
import services.implementations.BookService;
import services.implementations.InMemoryBookRepository;
import view.Window;

void main() {
    BookRepository repository = new InMemoryBookRepository();
    var service = new BookService(repository);
    var controller = new BookController(service);

    var wnd = new Window(controller);
    controller.attachView(wnd);

    wnd.setVisible(true);
}