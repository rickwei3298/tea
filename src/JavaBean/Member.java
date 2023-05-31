package JavaBean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Member {
    Integer id;
    String username;
    String password;
    String sex;
    String tel;
    String email;
    Integer userState;
    Integer userType;

    String uid01;
    String uid02;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    Date created_time;

    public Member() {
    }

    public Member(Integer id, String username, String password, String sex, String tel, String email, Integer userState, Integer userType, String uid01, String uid02, Date created_time) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.tel = tel;
        this.email = email;
        this.userState = userState;
        this.userType = userType;
        this.uid01 = uid01;
        this.uid02 = uid02;
        this.created_time = created_time;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getUid01() {
        return uid01;
    }

    public void setUid01(String uid01) {
        this.uid01 = uid01;
    }

    public String getUid02() {
        return uid02;
    }

    public void setUid02(String uid02) {
        this.uid02 = uid02;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", userState=" + userState +
                ", userType=" + userType +
                ", uid01='" + uid01 + '\'' +
                ", uid02='" + uid02 + '\'' +
                ", created_time=" + created_time +
                '}';
    }
}
