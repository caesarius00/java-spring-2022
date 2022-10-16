public class Author {
    String name, email;
    Enum<Gender> gender;

    Author(String name, String email, Enum<Gender> gender){
        this.email=email;
        this.name=name;
        this.gender=gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Enum<Gender> getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author[" + "name=" + name + ", email=" + email + ", gender=" + gender + ']';
    }
}
