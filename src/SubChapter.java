// SubChapter.java
import java.util.ArrayList;
import java.util.List;

public class SubChapter {
    private String name;
    private List<Object> content = new ArrayList<>();

    public SubChapter(String name) {
        this.name = name;
    }

    public void addContent(Object element) {
        content.add(element);
    }

    public void print() {
        System.out.println("Subchapter: " + name);
        for (Object obj : content) {
            if (obj instanceof Image) {
                ((Image)obj).print();
            } else if (obj instanceof Paragraph) {
                ((Paragraph)obj).print();
            } else if (obj instanceof Table) {
                ((Table)obj).print();
            }
        }
    }
}
