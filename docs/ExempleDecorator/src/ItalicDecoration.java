public class ItalicDecoration extends HTMLFormatterDecorator{
    public ItalicDecoration(TextFormatter tf) {
        super(tf);
    }

    public String getHTML(String s) {
        return "<i>" + _decorated_formatter.getHTML(s) + "</i>";
    }
}
