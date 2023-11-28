
public abstract class HTMLFormatterDecorator implements TextFormatter {

    protected TextFormatter _decorated_formatter;

    public HTMLFormatterDecorator(TextFormatter tf) {
        _decorated_formatter = tf;
    }
    public abstract String getHTML(String s);
}
