package laserprint.DTO;

import java.util.Date;

/**
 * Created by nhkha on 8/14/2017.
 */
public class BookDTO {
    private int bookId;
    private int studentId;
    private Date expiryDate;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
