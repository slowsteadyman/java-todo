package todo;

public class TodoLongestFieldLen {
    private int idLen;
    private int nameLen;
    private int descriptionLen;
    private int tabNameLen;

    public TodoLongestFieldLen() {
        this.idLen = "id".length();
        this.nameLen = "name".length();
        this.descriptionLen = "description".length();
        this.tabNameLen = "tabName".length();
    }

    public int getIdLen() {
        return this.idLen;
    }

    public void setIdLen(int len) {
        this.idLen = len;
    }

    public int getNameLen() {
        return this.nameLen;
    }

    public void setNameLen(int len) {
        this.nameLen = len;
    }

    public int getDescriptionLen() {
        return this.descriptionLen;
    }

    public void setDescriptionLen(int len) {
        this.descriptionLen = len;
    }

    public int getTabNameLen() {
        return this.tabNameLen;
    }

    public void setTabNameLen(int len) {
        this.tabNameLen = len;
    }
}
