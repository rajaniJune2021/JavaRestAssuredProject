public class CustomerDetails {
    String title;
    String body;
    String userId;
    int id;
    public CustomerDetails(){

    }
    public CustomerDetails(String title, String body, String userId){
        this.title=title;
        this.body=body;
        this.userId=userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle(){
        return  title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String toString(){
        return "response values are:"+this.title+" "+ this.body+" "+this.userId;
    }
}
