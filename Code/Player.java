public class Player {
    final int playerID;

    private String name;
    private String schoolClass;
    private String mail;
    private String phoneNumber;

    public Player(int playerID, String playerName, String schoolClass, String mail, String phoneNumber) {
        this.playerID = playerID;
        this.name = playerName;
        this.schoolClass = schoolClass;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public Player(String name, String schoolClass, String mail, String phoneNumber) {
        this.playerID = -1;
        this.name = name;
        this.schoolClass = schoolClass;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public Player copyPlayer(int newID){
        Player newPlayer = new Player(newID, this.name, this.schoolClass, this.mail, this.phoneNumber);
        return newPlayer;
    }


    @Override
    public String toString() {
        String tmp = "";

        String IDString = "";

        if (this.playerID == -1) {
            IDString = "Not given an ID, yet";
        } else {
            IDString = Integer.toString(this.playerID);
        }

        tmp += "PlayerID: " + this.playerID + ", name: " + this.name+ ", school class: " + this.schoolClass + ", email: " + this.mail + ", phone number: " + this.phoneNumber;


        return tmp;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
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
