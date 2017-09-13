package laserprint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sun.rmi.runtime.Log;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Trung on 7-8-2016.
 */

@Entity
@Table(name="Student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String birthday;
    private String phoneNumber;
    private String address;
    private String skype;
    private String email;
    private String desire;
    private String avatar;
    private String studentCode;
    private String cash;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    private User user;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<LogTien> logTiens;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<BookStudent> bookStudents;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<GuiXe> guiXes;

    public Student(){}

    public Student(String fullName, String studentCode, String birthday, String phoneNumber, String desire, String address){
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.address = address;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.desire = desire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesire() {
        return desire;
    }

    public void setDesire(String desire) {
        this.desire = desire;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public List<BookStudent> getBookStudents() {
        return bookStudents;
    }

    public void setBookStudents(List<BookStudent> bookStudents) {
        this.bookStudents = bookStudents;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public List<GuiXe> getGuiXes() {
        return guiXes;
    }

    public void setGuiXes(List<GuiXe> guiXes) {
        this.guiXes = guiXes;
    }

    public List<LogTien> getLogTiens() {
        return logTiens;
    }

    public void setLogTiens(List<LogTien> logTiens) {
        this.logTiens = logTiens;
    }
}
