package laserprint.DTO;

import java.util.Date;

/**
 * Created by nhkha on 8/14/2017.
 */
public class QRCodeDTO {
    private String readerId;
    private Date readTime;
    private String qrData;

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
