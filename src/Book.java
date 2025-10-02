// Book.java
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Chapter> chapters = new ArrayList<>();
    private TableOfContents tableOfContents;

    public Book(String title) {
        this.title = title;
        this.tableOfContents = new TableOfContents();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    public void print() {
        System.out.println("Book: " + title);
        for (Author a : authors) {
            a.print();
        }
        for (Chapter c : chapters) {
            c.print();
        }
        tableOfContents.print();
    }
}
