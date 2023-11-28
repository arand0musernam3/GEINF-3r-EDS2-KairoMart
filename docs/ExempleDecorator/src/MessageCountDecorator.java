public class MessageCountDecorator extends HTMLFormatterDecorator{
    private int _n;

    public MessageCountDecorator(TextFormatter tf) {
        super(tf);
        _n = 0;
    }

    public String getHTML(String s) {
        _n++;
        return  _n + ". " + _decorated_formatter.getHTML(s);
    }
}
