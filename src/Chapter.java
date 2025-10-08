import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String name;
    private List<Paragraph> paragraphs;
    private List<SubChapter> subChapters;

    public Chapter(String name) {
        this.name = name;
        this.paragraphs = new ArrayList<>();
        this.subChapters = new ArrayList<>();
    }

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public void addSubChapter(SubChapter subChapter) {
        subChapters.add(subChapter);
    }

    public void print() {
        System.out.println("Chapter: " + name);
        for (Paragraph p : paragraphs) {
            p.print();
        }
        for (SubChapter sc : subChapters) {
            sc.print();
        }
    }
}
