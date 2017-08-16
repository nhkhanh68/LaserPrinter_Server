package laserprint.service;

import laserprint.DTO.BookDTO;
import laserprint.DTO.QRCodeDTO;
import laserprint.DTO.StudentDTO;
import laserprint.DTO.UserDTO;
import laserprint.model.*;
import laserprint.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by nhkha on 25/03/2017.
 */
@Service
public class UserService {
    private final
    UserRepository userRepository;

    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final BookStudentRepository bookStudentRepository;
    private final QRCodeRepository qrCodeRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public UserService(UserRepository userRepository, StudentRepository studentRepository, BookRepository bookRepository,
                       BookStudentRepository bookStudentRepository, QRCodeRepository qrCodeRepository,
                       SimpMessagingTemplate simpMessagingTemplate) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
        this.bookStudentRepository = bookStudentRepository;
        this.qrCodeRepository = qrCodeRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public User Login(UserDTO userDTO) {
        User user = userRepository.findByUserName(userDTO.getUserName());
        if(user != null){
            if (userDTO.getPassword().equals(user.getPassword())) {
                if (user.getToken() == null) {
                    user.setToken(UUID.randomUUID().toString());
                }
                return userRepository.save(user);
            } else{
                throw new NullPointerException("Wrong password");
            }
        } else{
            throw new NullPointerException("Worng username");
        }
    }

    public void Logout(String token) {
        User user = userRepository.findByToken(token);
        user.setToken(null);
        userRepository.save(user);
    }

    public BookStudent borrowBook(BookDTO bookDTO) throws Exception {
        Student student = studentRepository.findById(bookDTO.getStudentId());
        if(student != null){
            Book book = bookRepository.findById(bookDTO.getBookId());
            if(book != null){
                if(bookDTO.getExpiryDate() != null){
                    BookStudent bookStudent = new BookStudent(book, student, bookDTO.getExpiryDate());
                    return bookStudentRepository.save(bookStudent);
                } else {
                    throw new Exception("Chưa có ngày hết hạn");
                }
            } else {
                throw new Exception("Không tìm thấy sách");
            }
        } else {
            throw new Exception("Không tìm thấy sinh viên");
        }
    }

    public QRCodeDTO readQRCode(QRCodeDTO qrCodeDTO) throws Exception {
        if(qrCodeDTO.getQrData() != null && qrCodeDTO.getReaderId()!= null && qrCodeDTO.getReadTime() != null){
            QRCode qrCode = new QRCode(qrCodeDTO.getReaderId(), qrCodeDTO.getReadTime(), qrCodeDTO.getQrData());
            qrCodeRepository.save(qrCode);
            Student student = studentRepository.findByStudentCode(qrCode.getQrData());
            StudentDTO studentDTO = new StudentDTO();
            if(student == null){
                studentDTO.setFullName("Không tìm thấy sinh viên");
                studentDTO.setAddress("NF");
                simpMessagingTemplate.convertAndSend("/user/khanh/**", studentDTO);
                qrCodeDTO.setQrData("Không tìm thấy sinh viên");
                return qrCodeDTO;
            } else {
                studentDTO.setFullName(student.getFullName());
                studentDTO.setAddress("F");
                studentDTO.setId(student.getId());
                studentDTO.setStudentCode(student.getStudentCode());
                simpMessagingTemplate.convertAndSend("/user/khanh/**", studentDTO);
                qrCodeDTO.setQrData(student.getFullName());
                return qrCodeDTO;
            }
        } else {
            throw new Exception("Thiếu dữ liệu!");
        }
    }

    public List<BookStudent> getAllBookStudent(){
        return bookStudentRepository.findAll();
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book addBook(BookDTO bookDTO){
        Book book = new Book(bookDTO.getBookName());
        return bookRepository.save(book);
    }

    public void deleteBook(int bookId) throws Exception {
        Book book = bookRepository.findById(bookId);
        if(book != null){
            bookRepository.delete(book);
        } else {
            throw new Exception("Không tìm thấy sách");
        }
    }

    public Student addStudent(StudentDTO studentDTO){
        Student student = new Student(studentDTO.getFullName(), studentDTO.getStudentCode());
        return studentRepository.save(student);
    }

    public void deleteStudent(int studentId) throws Exception {
        Student student = studentRepository.findById(studentId);
        if(student != null){
            studentRepository.delete(student);
        } else {
            throw new Exception("Không tìm thấy sinh viên");
        }
    }
}
