package com.splab.proiect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    // 1. Injectăm noul nostru executor asincron
    private final AsyncCommandExecutor asyncCommandExecutor;

    public BooksController(BooksService booksService, 
                           AsyncCommandExecutor asyncCommandExecutor) {
        this.booksService = booksService;
        this.asyncCommandExecutor = asyncCommandExecutor;
    }

    // --- PROCESARE SINCRONĂ (Rapidă) ---
    // Acestea rămân la fel, execută comanda direct
    
    @GetMapping
    public List<Book> getAllBooks() {
        System.out.println("Controller: Se creează GetAllBooksCommand (Sincron)");
        Command<List<Book>> command = new GetAllBooksCommand(booksService);
        return command.execute(); 
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        System.out.println("Controller: Se creează GetBookByIdCommand (Sincron)");
        Command<Book> command = new GetBookByIdCommand(booksService, id);
        return command.execute();
    }

    // --- PROCESARE ASINCRONĂ (Lentă) ---
    // Task 16: Schimbăm metoda POST
    
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book bookData) {
        long threadId = Thread.currentThread().getId();
        System.out.println(
            "Controller: Primit POST pe thread-ul: " + threadId
        );
        System.out.println("Controller: Se creează AddBookCommand (Asincron)");

        // 1. Creăm comanda
        Command<Book> command = new AddBookCommand(
            booksService, 
            bookData.getTitle(), 
            bookData.getAuthor()
        );
        
        // 2. NU o executăm. O trimitem executorului să o ruleze în fundal.
        asyncCommandExecutor.executeCommand(command);

        // 3. Răspundem imediat clientului cu HTTP 202 ACCEPTED
        // 
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Cartea este procesată în fundal.");
    }
    
    // TODO: Lasă update și delete ca exercițiu
    // (momentan sunt sincrone, dar le poți face asincrone la fel ca POST)

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book bookData) {
        System.out.println("Controller: Se creează UpdateBookCommand (Sincron)");
        Command<Book> command = new UpdateBookCommand(
            booksService, id, bookData.getTitle(), bookData.getAuthor()
        );
        return command.execute();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBook(@PathVariable("id") int id) {
        System.out.println("Controller: Se creează DeleteBookCommand (Sincron)");
        Command<Boolean> command = new DeleteBookCommand(booksService, id);
        return command.execute();
    }
}