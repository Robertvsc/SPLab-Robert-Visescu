package com.splab.proiect;

// Importăm interfața NOASTRĂ, nu pe cea de la Spring
import com.splab.proiect.persistence.MyCrudRepository; 
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    // Acum depindem de interfața noastră abstractă!
    private final MyCrudRepository<Book, Integer> bookRepository;

    // Spring va injecta automat "Adaptorul" (BooksRepositoryAdapter)
    // pentru că este singura clasă care implementează această interfață
    public BooksService(MyCrudRepository<Book, Integer> bookRepository) {
        this.bookRepository = bookRepository;

        // Adăugăm datele de test
        // (Verificăm dacă e goală, ca să nu le adauge la fiecare pornire)
        if (bookRepository.findAll().isEmpty()) {
            addBook("Cartea 1", "Autor 1");
            addBook("Cartea 2", "Autor 2");
        }
    }

    // Restul codului este IDENTIC, 
    // pentru că interfața noastră are aceleași nume de metode

    public List<Book> getAllBooks() {
        System.out.println("BooksService: Se cer toate cărțile (prin Adapter)");
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        System.out.println("BooksService: Se caută cartea cu id " + id + " (prin Adapter)");
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null); 
    }

    public Book addBook(String title, String author) {
        Book newBook = new Book(); 
        newBook.setTitle(title);
        newBook.setAuthor(author);

        Book savedBook = bookRepository.save(newBook);
        System.out.println("BooksService: S-a salvat cartea (prin Adapter): " + savedBook);
        return savedBook;
    }

    public Book updateBook(int id, String title, String author) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            Book bookToUpdate = bookOptional.get();
            bookToUpdate.setTitle(title);
            bookToUpdate.setAuthor(author);

            Book updatedBook = bookRepository.save(bookToUpdate);
            System.out.println("BooksService: S-a actualizat cartea (prin Adapter): " + updatedBook);
            return updatedBook;
        } else {
            System.out.println("BooksService: Cartea cu id " + id + " nu a fost găsită pentru actualizare.");
            return null; 
        }
    }

    public boolean deleteBook(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            System.out.println("BooksService: S-a șters cartea cu id " + id + " (prin Adapter)");
            return true;
        } else {
            System.out.println("BooksService: Cartea cu id " + id + " nu a fost găsită pentru ștergere.");
            return false;
        }
    }
}