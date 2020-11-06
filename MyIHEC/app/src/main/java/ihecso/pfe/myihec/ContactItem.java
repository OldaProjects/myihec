package ihecso.pfe.myihec;


public class ContactItem {
    private String label;

    // Image name (Without extension)
    private String icon;
    private String text;

    public ContactItem(String label, String icon, String text) {
        this.label = label;
        this.icon = icon;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString()  {
        return this.label +" (Info: "+ this.text +")";
    }
}
