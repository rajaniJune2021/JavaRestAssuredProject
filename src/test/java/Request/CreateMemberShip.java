package Request;

public class CreateMemberShip {

    public String emailAddress;
    public String password;
    public String membershipExpDate;
    public String membershipNumber;
    public String dateOfBirth;

    public CreateMemberShip(){

    }

    public CreateMemberShip(String emailAddress,String password, String membershipExpDate, String membershipNumber, String dateOfBirth){
        this.emailAddress = emailAddress;
        this.password = password;
        this.membershipExpDate = membershipExpDate;
        this.membershipNumber = membershipNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getMembershipExpDate() {
        return membershipExpDate;
    }

    public void setMembershipExpDate(String membershipExpDate) {
        this.membershipExpDate = membershipExpDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
