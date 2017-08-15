package laserprint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nhkha on 8/14/2017.
 */
@Entity
@Table(name="Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String bookName;
    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<BookStudent> bookStudents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<BookStudent> getBookStudents() {
        return bookStudents;
    }

    public void setBookStudents(List<BookStudent> bookStudents) {
        this.bookStudents = bookStudents;
    }
}
