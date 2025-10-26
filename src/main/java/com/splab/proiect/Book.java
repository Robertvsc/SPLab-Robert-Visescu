package com.splab.proiect;

// Am scos "final" ca să o putem modifica
public class Book {

    private int id;       // Am scos "final"
    private String title;  // Am scos "final"
    private String author; // Am scos "final"

    // 1. Constructor gol (Default Constructor)
    // Jackson are nevoie de asta pentru a crea un obiect gol
    public Book() {
    }

    // Constructorul nostru vechi, încă util
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters (erau deja)
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // 2. Setters
    // Jackson folosește astea pentru a seta valorile din JSON
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}