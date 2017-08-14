package laserprint.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nhkha on 8/14/2017.
 */
@Entity
@Table(name = "QRCode")
public class QRCode {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String readerId;
    private Date readTime;
    private String qrData;

    public QRCode(){}

    public QRCode(String readerId, Date readTime, String qrData){
        this.readerId = readerId;
        this.readTime = readTime;
        this.qrData = qrData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public String getQrData() {
        return qrData;
    }

    public void setQrData(String qrData) {
        this.qrData = qrData;
    }
}
