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

        Paragraph p4 = new Paragraph("Text aliniat la stanga");
        Paragraph p2 = new Paragraph("Text aliniat la dreapta");
        Paragraph p3 = new Paragraph("Text centrat");

        p4.setAlignStrategy(new AlignLeft());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignCenter());

        p4.print();
        p2.print();
        p3.print();
    }
}
