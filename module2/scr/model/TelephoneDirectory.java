package model;

public class TelephoneDirectory {
    private String phone;
    private String team;
    private String fullname;
    private String gender;
    private String address;
    private String birthDate;
    private String email;

    public TelephoneDirectory() {
    }

    public TelephoneDirectory(String phone, String team, String fullname, String gender, String address, String birthDate, String email) {
        this.phone = phone;
        this.team = team;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }

    public TelephoneDirectory(String record) {
        String[] fields = record.split(",");
        phone = fields[0];
        team = fields[1];
        fullname = fields[2];
        gender = fields[3];
        address = fields[4];
        birthDate = fields[5];
        email = fields[6];
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                phone + ',' +
                        team + ',' +
                        fullname + ',' +
                        gender + ',' +
                        address + ',' +
                        birthDate + ',' +
                        email;
    }


}
