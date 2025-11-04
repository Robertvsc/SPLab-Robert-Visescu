package com.splab.proiect;

import com.splab.proiect.persistence.BooksRepository; // 1. Importă noul repository
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    
    // 2. Am șters lista "in-memory" și counter-ul
    
    // 3. Injectăm repository-ul. Spring se ocupă de asta.
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
        
        // 4. Adăugăm datele de test direct în baza de date la pornire
        // (Doar dacă baza e goală, deși .save() face update oricum)
        addBook("Cartea 1", "Autor 1");
        addBook("Cartea 2", "Autor 2");
    }

    // --- Logica de business acum folosește REPOSITORY-UL ---

    public List<Book> getAllBooks() {
        System.out.println("BooksService: Se cer toate cărțile din BAZA DE DATE");
        // 5. Înlocuim "return books;"
        return booksRepository.findAll();
    }

    public Book getBookById(int id) {
        System.out.println("BooksService: Se caută cartea cu id " + id + " în BAZA DE DATE");
        // 6. Înlocuim logica cu stream().filter()
        Optional<Book> bookOptional = booksRepository.findById(id);
        return bookOptional.orElse(null); // Returnează cartea sau null
    }

    public Book addBook(String title, String author) {
        // 7. Când adăugăm, ID-ul este generat automat de @GeneratedValue
        Book newBook = new Book(); // Creăm un obiect gol
        newBook.setTitle(title);
        newBook.setAuthor(author);
        
        // 8. Folosim .save() pentru a o insera în baza de date
        Book savedBook = booksRepository.save(newBook);
        System.out.println("BooksService: S-a salvat cartea în BAZA DE DATE: " + savedBook);
        return savedBook;
    }

    public Book updateBook(int id, String title, String author) {
        // 9. Pentru update, mai întâi verificăm dacă există
        Optional<Book> bookOptional = booksRepository.findById(id);
        
        if (bookOptional.isPresent()) {
            Book bookToUpdate = bookOptional.get();
            bookToUpdate.setTitle(title);
            bookToUpdate.setAuthor(author);
            
            // 10. Folosim tot .save() pentru update.
            // Dacă obiectul are un @Id care există deja, .save() face UPDATE
            Book updatedBook = booksRepository.save(bookToUpdate);
            System.out.println("BooksService: S-a actualizat cartea în BAZA DE DATE: " + updatedBook);
            return updatedBook;
        } else {
            System.out.println("BooksService: Cartea cu id " + id + " nu a fost găsită pentru actualizare.");
            return null; 
        }
    }

    public boolean deleteBook(int id) {
        // 11. Verificăm dacă există înainte de a șterge
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            System.out.println("BooksService: S-a șters cartea cu id " + id + " din BAZA DE DATE");
            return true;
        } else {
            System.out.println("BooksService: Cartea cu id " + id + " nu a fost găsită pentru ștergere.");
            return false;
        }
    }
}