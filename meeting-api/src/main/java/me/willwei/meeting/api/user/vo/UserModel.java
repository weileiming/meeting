package me.willwei.meeting.api.user.vo;

import java.io.Serializable;

/**
 * UserModel
 *
 * @author leiming
 * @date 2019/2/18
 */
public class UserModel implements Serializable {

    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
