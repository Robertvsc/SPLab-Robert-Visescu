package com.splab.proiect;


public class AddBookCommand implements Command<Book> {

    private final BooksService booksService;
    // Comanda ține minte și parametrii necesari pentru execuție
    private final String title;
    private final String author;

    public AddBookCommand(BooksService booksService, String title, String author) {
        this.booksService = booksService;
        this.title = title;
        this.author = author;
    }

    @Override
    public Book execute() {
        return booksService.addBook(title, author);
    }
}