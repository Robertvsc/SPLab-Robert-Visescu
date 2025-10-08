public class Main {
    public static void main(String[] args) {
        System.out.println("=== Carte de test ===");

        Author author = new Author("Robert Visescu");
        Book book = new Book("SPLab - Design Patterns");
        book.addAuthor(author);

        Chapter chapter1 = new Chapter("Introducere");
        chapter1.addParagraph(new Paragraph("Asta e primul paragraf."));
        chapter1.addParagraph(new Paragraph("Alt paragraf de test."));
        book.addChapter(chapter1);

        System.out.println("=== Info carte ===");
        System.out.println("Autor: " + author.getName());
        System.out.println("Titlu: " + book.getTitle());
    }
}
