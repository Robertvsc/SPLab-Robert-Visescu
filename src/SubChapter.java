import java.util.ArrayList;
import java.util.List;

public class SubChapter {
    private String name;
    private List<Paragraph> paragraphs;

    public SubChapter(String name) {
        this.name = name;
        this.paragraphs = new ArrayList<>();
    }

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public void print() {
        System.out.println("SubChapter: " + name);
        for (Paragraph p : paragraphs) {
            p.print();
        }
    }
}
