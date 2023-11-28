public class Decorator {
    public static void main(String[] args) {
        //Variable declaration
        TextFormatter Form;
        String text = "Lorem ipsum";
        Form = new HTMLTextFormatter();
        System.out.println(Form.getHTML(text)); //input text

        //adding the bold decoratior
        Form = new BoldDecoration(Form);
        System.out.println(Form.getHTML(text));

        //adding both italics and underlining (in this order)
        Form = new ItalicDecoration(Form);
        Form = new UnderlineDecoration(Form);
        System.out.println(Form.getHTML(text));

        //adding a number counter
        Form = new MessageCountDecorator(Form);
        System.out.println(Form.getHTML(text));

        //showing the text again, now the number has increased
        System.out.println(Form.getHTML(text));

        //adding another counter, independent to the former
        Form = new MessageCountDecorator(Form);
        System.out.println(Form.getHTML(text));
        System.out.println(Form.getHTML(text));
        System.out.println(Form.getHTML(text));

        //adding one last bold attribute
        Form = new BoldDecoration(Form);
        System.out.println(Form.getHTML(text));
    }
}