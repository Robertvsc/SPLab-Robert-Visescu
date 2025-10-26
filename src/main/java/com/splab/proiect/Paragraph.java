public class Paragraph implements Element {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void add(Element element) {}
    @Override
    public void remove(Element element) {}
    @Override
    public Element get(int index) { return null; }

    private AlignStrategy alignStrategy;

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public String getText() {
        return text;
    }

    public void print() {
        System.out.print("Paragraph: ");
        if (alignStrategy == null) {
            System.out.println(text);
        } else {
            alignStrategy.render(this, null);
        }
    }

}
