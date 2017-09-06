package laserprint.service;

import laserprint.DTO.BookDTO;
import laserprint.DTO.QRCodeDTO;
import laserprint.DTO.StudentDTO;
import laserprint.DTO.UserDTO;
import laserprint.model.*;
import laserprint.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Date;
import java.util.List;
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
    private final GuiXeRepository guiXeRepository;

    @Autowired
    public UserService(UserRepository userRepository, StudentRepository studentRepository, BookRepository bookRepository,
                       BookStudentRepository bookStudentRepository, QRCodeRepository qrCodeRepository,
                       SimpMessagingTemplate simpMessagingTemplate, GuiXeRepository guiXeRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
        this.bookStudentRepository = bookStudentRepository;
        this.qrCodeRepository = qrCodeRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.guiXeRepository = guiXeRepository;
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

    public void traSach(List<BookDTO> list){
        for (BookDTO bookDTO : list){
            if(bookDTO.getId() != 0){
                BookStudent bookStudent = bookStudentRepository.findById(bookDTO.getId());
                if(bookStudent != null){
                    bookStudent.setStatus("Đã trả");
                    bookStudentRepository.save(bookStudent);
                }
            }
        }
    }

    public QRCodeDTO readQRCode(QRCodeDTO qrCodeDTO) throws Exception {
        if(qrCodeDTO.getQrData() != null && qrCodeDTO.getReaderId()!= null && qrCodeDTO.getReadTime() != null){
            QRCode qrCode = new QRCode(qrCodeDTO.getReaderId(), qrCodeDTO.getReadTime(), qrCodeDTO.getQrData());
//            System.out.print("\n" + qrCodeDTO.getReadTime().getDay()+"\n");
            qrCodeRepository.save(qrCode);
            Student student = studentRepository.findByStudentCode(qrCode.getQrData());
            StudentDTO studentDTO = new StudentDTO();
            if(student == null){
                studentDTO.setFullName("Không tìm thấy sinh viên");
                studentDTO.setAddress("NF");
                simpMessagingTemplate.convertAndSend("/user/student/**", studentDTO);
                qrCodeDTO.setQrData("Không tìm thấy sinh viên");
                return qrCodeDTO;
            } else {
                studentDTO.setFullName(student.getFullName());
                studentDTO.setAddress("F");
                studentDTO.setId(student.getId());
                studentDTO.setStudentCode(student.getStudentCode());
                studentDTO.setStudent(student);
                simpMessagingTemplate.convertAndSend("/user/student/**", studentDTO);
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

    public List<Student> getAllStudent(){
        return (List<Student>) studentRepository.findAll();
    }

    public Student addStudent(StudentDTO studentDTO) throws Exception {
        Student student1 = studentRepository.findByStudentCode(studentDTO.getStudentCode());
        if(student1 == null){
            Student student = new Student(studentDTO.getFullName(), studentDTO.getStudentCode(), studentDTO.getBirthday(), studentDTO.getPhoneNumber(), studentDTO.getDesire(), studentDTO.getAddress());
            return studentRepository.save(student);
        } else {
            throw new Exception("Mã sinh viên trùng");
        }

    }

    public void deleteStudent(int studentId) throws Exception {
        Student student = studentRepository.findById(studentId);
        if(student != null){
            studentRepository.delete(student);
        } else {
            throw new Exception("Không tìm thấy sinh viên");
        }
    }

    public void deleteBookStudent(int id) throws Exception {
        BookStudent bookStudent = bookStudentRepository.findOne(id);
        if(bookStudent != null){
            bookStudentRepository.delete(bookStudent);
        } else {
            throw new Exception("Không tìm thấy dữ liệu cần xóa!");
        }
    }

    public List<BookStudent> getAllBookStudentOfStudent(int studentId){
        return bookStudentRepository.findByStudentId(studentId);
    }

    public void readQRCodeNapTien(QRCodeDTO qrCodeDTO) throws Exception {
        if(qrCodeDTO.getQrData() != null && qrCodeDTO.getReaderId()!= null && qrCodeDTO.getReadTime() != null){
            QRCode qrCode = new QRCode(qrCodeDTO.getReaderId(), qrCodeDTO.getReadTime(), qrCodeDTO.getQrData());
            qrCodeRepository.save(qrCode);
            Student student = studentRepository.findByStudentCode(qrCode.getQrData());
            StudentDTO studentDTO = new StudentDTO();
            if(student == null){
                studentDTO.setFullName("Không tìm thấy sinh viên");
                simpMessagingTemplate.convertAndSend("/user/guixe/**", studentDTO);
            } else {
                studentDTO.setFullName(student.getFullName());
                studentDTO.setId(student.getId());
                studentDTO.setStudentCode(student.getStudentCode());
                studentDTO.setStudent(student);
                simpMessagingTemplate.convertAndSend("/user/guixe/**", studentDTO);
            }
        } else {
            throw new Exception("Thiếu dữ liệu!");
        }
    }

    public void napTien(StudentDTO studentDTO){
        Student student = studentRepository.findById(studentDTO.getId());
        if (student != null){
//            if(student.getCash().equals("")){
//                student.setCash(studentDTO.getCash());
//                studentRepository.save(student);
//            } else {
//                student.setCash(String.valueOf(Integer.valueOf(studentDTO.getCash()) + Integer.valueOf(student.getCash())));
//                studentRepository.save(student);
//            }
            student.setCash(studentDTO.getCash());
            studentRepository.save(student);
        }
    }

    public void checkinGuiXe(QRCodeDTO qrCodeDTO){
        if(qrCodeDTO.getQrData() != null && qrCodeDTO.getReaderId()!= null && qrCodeDTO.getReadTime() != null){
            QRCode qrCode = new QRCode(qrCodeDTO.getReaderId(), qrCodeDTO.getReadTime(), qrCodeDTO.getQrData());
            qrCodeRepository.save(qrCode);
            Student student = studentRepository.findByStudentCode(qrCode.getQrData());
            StudentDTO studentDTO = new StudentDTO();
            if(student == null){
                studentDTO.setFullName("Không tìm thấy sinh viên");
                simpMessagingTemplate.convertAndSend("/user/guixe/checkinGuiXe/**", studentDTO);
            } else {
                GuiXe guiXe = guiXeRepository.findTopByStudentIdAndCheckinIsNotNullAndCheckoutIsNull(student.getId());
                if(guiXe == null){
                    GuiXe guiXe1 = new GuiXe(student);
                    guiXeRepository.save(guiXe1);
                }
//                simpMessagingTemplate.convertAndSend("/user/student/guixe/**", studentDTO);
            }
        }
    }

    public void checkoutGuiXe(QRCodeDTO qrCodeDTO){
        if(qrCodeDTO.getQrData() != null && qrCodeDTO.getReaderId()!= null && qrCodeDTO.getReadTime() != null){
            QRCode qrCode = new QRCode(qrCodeDTO.getReaderId(), qrCodeDTO.getReadTime(), qrCodeDTO.getQrData());
            qrCodeRepository.save(qrCode);
            Student student = studentRepository.findByStudentCode(qrCode.getQrData());
            StudentDTO studentDTO = new StudentDTO();
            if(student == null){
                studentDTO.setFullName("Không tìm thấy sinh viên");
                simpMessagingTemplate.convertAndSend("/user/guixe/checkoutGuiXe/**", studentDTO);
            } else {
                GuiXe guiXe = guiXeRepository.findTopByStudentIdAndCheckinIsNotNullAndCheckoutIsNull(student.getId());
                if(guiXe != null){
                    guiXe.setCheckout(new Date());
                    User user = userRepository.findByUserName("tienGuiXe");
                    if(Integer.valueOf(student.getCash()) < Integer.valueOf(user.getPassword())){
                        studentDTO.setFullName("Không đủ tiền!");
                        simpMessagingTemplate.convertAndSend("/user/guixe/checkoutGuiXe/**", studentDTO);
                    } else {
                        student.setCash(String.valueOf(Integer.valueOf(student.getCash()) - Integer.valueOf(user.getPassword())));
                        studentRepository.save(student);
                    }
                }
//                simpMessagingTemplate.convertAndSend("/user/student/guixe/**", studentDTO);
            }
        }
    }

    public List<GuiXe> getAllGuiXe(){
        return (List<GuiXe>) guiXeRepository.findAll();
    }

    public UserDTO xemMucTienGuiXe(){
        User user = userRepository.findByUserName("tienGuiXe");
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public void thayDoiMucTienGuiXe(String cash){
        User user = userRepository.findByUserName("tienGuiXe");
        user.setPassword(cash);
        userRepository.save(user);
    }
}
