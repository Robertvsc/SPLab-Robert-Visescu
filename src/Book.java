import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private List<Chapter> chapters;

    public Book(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.chapters = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void print() {
        System.out.println("Book: " + title);
        for (Author a : authors) {
            a.print();
        }
        for (Chapter c : chapters) {
            c.print();
        }
    }
}
