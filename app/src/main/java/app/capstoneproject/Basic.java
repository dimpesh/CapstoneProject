package app.capstoneproject;

/**
 * Created by DIMPESH : ${month}
 */
public class Basic
{
    String email;
    String phone;
    String name;

    public Basic() {
    }

    public Basic(String email, String phone, String name) {
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
