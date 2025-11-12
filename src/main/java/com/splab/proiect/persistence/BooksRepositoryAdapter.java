package com.splab.proiect.persistence;

import com.splab.proiect.Book;
import org.springframework.stereotype.Component; 

import java.util.List;
import java.util.Optional;


@Component 
public class BooksRepositoryAdapter implements MyCrudRepository<Book, Integer> {

    // Injectăm repository-ul real de Spring Data
    private final BooksRepository springDataRepository;

    public BooksRepositoryAdapter(BooksRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    // "Traducem" apelurile

    @Override
    public List<Book> findAll() {
        return springDataRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return springDataRepository.findById(id);
    }

    @Override
    public Book save(Book entity) {
        return springDataRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        springDataRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return springDataRepository.existsById(id);
    }
}