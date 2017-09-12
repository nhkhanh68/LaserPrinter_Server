package laserprint.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="GuiXe")
public class GuiXe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date checkin;
    private Date checkout;
    private String bienSo;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    private String status;

    public GuiXe(){}

    public GuiXe(Student student, String s){
        this.student = student;
        this.checkin = new Date();
        this.bienSo = s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkin;
    }

    public void setCheckIn(Date checkIn) {
        this.checkin = checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
