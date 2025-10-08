package src;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Carte de test ===");

        Author author = new Author("Robert Visescu");
        Book book = new Book("SPLab - Design Patterns");
        book.addAuthor(author);

        Chapter chapter1 = new Chapter("Introducere");
        chapter1.addParagraph(new Paragraph("Asta e primul paragraf"));
        chapter1.addParagraph(new Paragraph("Al doilea paragraf introducere"));
        book.addChapter(chapter1);

        Chapter chapter2 = new Chapter("Introducere");
        chapter2.addSubChapter(new SubChapter("Definitie"));
        chapter2.addSubChapter(new SubChapter("Implementatare exemplu"));
        book.addChapter(chapter2);

        System.out.println("\n=== Info carte ===");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + author.getName());
        System.out.println("Chapters: " + book.getChapters().size());
    }
}
