public class BoldDecoration extends HTMLFormatterDecorator{
    public BoldDecoration(TextFormatter tf) {
        super(tf);
    }

    public String getHTML(String s) {
        return "<b>" + _decorated_formatter.getHTML(s) + "</b>";
    }
}
