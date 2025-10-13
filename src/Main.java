public class Main {
    public static void main(String[] args) {
        Book book = new Book("Carte de test Design Patterns");
        Author author = new Author("Robert", "Visescu");
        book.addAuthor(author);

        Section cap1 = new Section("Capitolul 1 - Introducere");
        Paragraph p1 = new Paragraph("Acesta este primul paragraf.");
        Image img1 = new Image("img1.png");
        Table t1 = new Table("Tabel 1");

        cap1.add(p1);
        cap1.add(img1);
        cap1.add(t1);

        book.addContent(new TableOfContents());
        book.addContent(cap1);

        book.print();
    }
}
