package laserprint.DTO;

import laserprint.model.Student;

/**
 * Created by Trung on 7/11/2016.
 */
public class StudentDTO {
    private int id;
    private String fullName;
    private String birthday;
    private String phoneNumber;
    private String address;
    private String skype;
    private String email;
    private String desire;
    private String avatar;
    private String lecturersEmail;
    private String STT;
    private String studentCode;
    private Student student;
    private String cash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLecturersEmail() {
        return lecturersEmail;
    }

    public void setLecturersEmail(String lecturersEmail) {
        this.lecturersEmail = lecturersEmail;
    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }
}
