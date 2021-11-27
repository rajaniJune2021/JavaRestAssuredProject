package Request;

public class LoginMembershipRequestBody {

    public String username;
    public String password;
    public String clubCode;

    public LoginMembershipRequestBody(){

    }

    public LoginMembershipRequestBody(String username, String password, String clubCode){
        this.username = username;
        this.password = password;
        this.clubCode = clubCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
