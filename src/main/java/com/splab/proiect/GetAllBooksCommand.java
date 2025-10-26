package com.splab.proiect;

import java.util.List;

// Task 12: Comandă concretă
public class GetAllBooksCommand implements Command<List<Book>> {

    // Comanda are o referință la Receiver
    private final BooksService booksService;

    // Injectăm Receiver-ul prin constructor
    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        // Logica comenzii este să apeleze metoda corespunzătoare pe Receiver
        return booksService.getAllBooks();
    }
}