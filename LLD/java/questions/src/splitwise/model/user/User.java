package splitwise.model.user;

public class User {
    private String name;
    private String email;
    private String phnNum;

    public User(String name, String email, String phnNum) {
        this.name = name;
        this.email = email;
        this.phnNum = phnNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhnNum() {
        return phnNum;
    }

    public void setPhnNum(String phnNum) {
        this.phnNum = phnNum;
    }
}
