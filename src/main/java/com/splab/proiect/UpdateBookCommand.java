package com.splab.proiect;

public class UpdateBookCommand implements Command<Book> {

    private final BooksService booksService;
    private final int id;
    private final String title;
    private final String author;

    public UpdateBookCommand(BooksService booksService, int id, String title, String author) {
        this.booksService = booksService;
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public Book execute() {
        return booksService.updateBook(id, title, author);
    }
}