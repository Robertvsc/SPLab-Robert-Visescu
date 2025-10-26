package com.splab.proiect;

public class DeleteBookCommand implements Command<Boolean> {

    private final BooksService booksService;
    private final int id;

    public DeleteBookCommand(BooksService booksService, int id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        return booksService.deleteBook(id);
    }
}