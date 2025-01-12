package Learn.InterStar_Travel.Models;

import java.util.Objects;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public User(){}

    public User(int userId, String firstName, String lastName, String email, String phoneNumber){
       this.userId = userId;
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.phoneNumber = phoneNumber;
    }

    public User(String firstName, String lastName, String email, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // check if they are the same instance
        if (o == null || getClass() != o.getClass()) return false; // check if the other object is null or not of the same class
        User user = (User) o; // cast the object to User
        return userId == user.userId && // check userId equality
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber);
    }

    // Override hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, phoneNumber); // generate hashCode based on all fields
    }
}
