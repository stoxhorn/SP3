public class Player {
    final int playerID;

    private String name;
    private String schoolClass;
    private String mail;
    private String phoneNumber;

    public Player(int playerID, String name, String schoolClass, String mail, String phoneNumber) {
        this.playerID = playerID;
        this.name = name;
        this.schoolClass = schoolClass;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
