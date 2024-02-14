package splitwise.model.expense;

public class ExpenseMetaData {
    private String notes;
    private String image;
    private String name;

    public ExpenseMetaData(String notes, String image, String name) {
        this.notes = notes;
        this.image = image;
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
