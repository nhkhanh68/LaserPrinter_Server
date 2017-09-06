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

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public GuiXe(){}

    public GuiXe(Student student){
        this.student = student;
        this.checkin = new Date();
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
}
