package app.capstoneproject;

/**
 * Created by DIMPESH : ${month}
 */
public class Other {
    String fname;
    String mname;
    String dob;
    String address;
    char gender;

    public Other(String fname, String mname, char gender, String dob, String address) {
        this.fname = fname;
        this.mname = mname;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
    }

    public Other() {

    }

    public String getFname() {
        return fname;
    }

    public String getMname() {
        return mname;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public char getGender() {
        return gender;
    }
}
