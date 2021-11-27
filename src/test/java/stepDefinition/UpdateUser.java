package stepDefinition;

public class UpdateUser {

    public String name;
    public String job;
    public String updatedAt;

    public UpdateUser(){

    }
    public UpdateUser(String name, String job){
        this.name = name;
        this.job = job;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
