package laserprint.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nhkha on 8/14/2017.
 */
@Entity
@Table(name="BookStudent")
public class BookStudent {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date borrowedDate;
    private Date expiryDate;
//    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

//    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public BookStudent(){}

    public BookStudent(Book book, Student student, Date expiryDate){
        this.book = book;
        this.student = student;
        this.expiryDate = expiryDate;
        this.borrowedDate = new Date();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
