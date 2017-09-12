package laserprint.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="LogTien")
public class LogTien {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String status;
    private Date time;
    private String cash;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public LogTien(){}

    public LogTien(String status, String cash, Student student) {
        this.status = status;
        this.time = new Date();
        this.cash = cash;
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
