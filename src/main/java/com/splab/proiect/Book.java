package com.splab.proiect;

// Importurile necesare pentru JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // TASK 4: Spune JPA că această clasă este un tabel
public class Book {

    @Id // TASK 4: Spune JPA că acesta este cheia primară (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // TASK 4: Spune bazei de date să genereze automat acest ID
    private int id;
    private String title;
    private String author;

    // Constructor gol (JPA are nevoie de el)
    public Book() {
    }
    
    // Constructorul nostru vechi
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
    // Setters
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