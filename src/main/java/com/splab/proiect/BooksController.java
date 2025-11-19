package com.splab.proiect;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    // 1. Adăugăm Subiectul (Observer Pattern)
    private final AllBooksSubject allBooksSubject;

    // 2. Injectăm ambele dependențe în constructor
    public BooksController(BooksService booksService, AllBooksSubject allBooksSubject) {
        this.booksService = booksService;
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return booksService.getBookById(id);
    }

    // 3. Modificăm metoda POST pentru a notifica observatorii
    @PostMapping
    public Book createBook(@RequestBody Book bookData) {
        // Salvăm cartea folosind service-ul
        Book savedBook = booksService.addBook(bookData.getTitle(), bookData.getAuthor());

        // NOTIFICĂM observatorii (inclusiv browser-ul prin SSE) despre noua carte
        allBooksSubject.add(savedBook);

        return savedBook;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book bookData) {
        return booksService.updateBook(id, bookData.getTitle(), bookData.getAuthor());
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBook(@PathVariable("id") int id) {
        return booksService.deleteBook(id);
    }
}