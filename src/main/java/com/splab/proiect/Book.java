import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> content = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        content.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        for (Author a : authors) {
            a.print();
        }
        for (Element e : content) {
            e.print();
        }
    }
}
