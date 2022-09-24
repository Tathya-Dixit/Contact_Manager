public class Messages {
    private String text;
    private String recipient;
    private Contacts c;

    public Messages(Contacts c, String text, String recipient) {
        this.text = text;
        this.recipient = recipient;
        this.c = c;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Contacts getC() {
        return c;
    }

    public void setC(Contacts c) {
        this.c = c;
    }
}
