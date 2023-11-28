public class UnderlineDecoration extends HTMLFormatterDecorator{
    public UnderlineDecoration(TextFormatter tf) {
        super(tf);
    }

    public String getHTML(String s) {
        return "<u>" + _decorated_formatter.getHTML(s) + "</u>";
    }
}
