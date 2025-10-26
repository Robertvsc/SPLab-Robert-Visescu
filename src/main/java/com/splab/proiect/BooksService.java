package com.splab.proiect;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BooksService {
    
    private final List<Book> books = new CopyOnWriteArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(); 

    public BooksService() {
        addBook("Cartea 1", "Autor 1");
        addBook("Cartea 2", "Autor 2");
    }

    public List<Book> getAllBooks() {
        System.out.println("BooksService: Se returnează toate cărțile");
        return books;
    }

    public Book getBookById(int id) {
        System.out.println("BooksService: Se caută cartea cu id " + id);
        return books.stream()
                // Aici e modificarea: .getId()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null); 
    }

    public Book addBook(String title, String author) {
        int newId = idCounter.incrementAndGet();
        Book newBook = new Book(newId, title, author);
        books.add(newBook);
        System.out.println("BooksService: S-a adăugat cartea: " + newBook);
        return newBook;
    }

    public Book updateBook(int id, String title, String author) {
        Book updatedBook = new Book(id, title, author);
        
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            // Aici e modificarea: .getId()
            if (books.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            books.set(index, updatedBook); 
            System.out.println("BooksService: S-a actualizat cartea: " + updatedBook);
            return updatedBook;
        }
        System.out.println("BooksService: Cartea cu id " + id + " nu a fost găsită pentru actualizare.");
        return null;
    }

    public boolean deleteBook(int id) {
        // Aici e modificarea: .getId()
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (removed) {
            System.out.println("BooksService: S-a șters cartea cu id " + id);
        } else {
            System.out.println("BooksService: Cartea cu id " + id + " nu a fost găsită pentru ștergere.");
        }
        return removed;
    }
}