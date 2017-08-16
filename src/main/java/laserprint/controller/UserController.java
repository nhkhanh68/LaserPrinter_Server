package laserprint.controller;

import laserprint.DTO.BookDTO;
import laserprint.DTO.QRCodeDTO;
import laserprint.DTO.StudentDTO;
import laserprint.DTO.UserDTO;
import laserprint.model.Book;
import laserprint.model.BookStudent;
import laserprint.model.Student;
import laserprint.model.User;
import laserprint.service.UserService;
//import laserprint.stereotype.RequiredRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * Created by nhkha on 25/03/2017.
 */
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //login
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public User Login(@RequestBody UserDTO userDTO) {
        return userService.Login(userDTO);
    }

    //logout
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public void Logout(HttpServletRequest request){
        String token = request.getHeader("auth-token");
        userService.Logout(token);
    }

    @RequestMapping(value = "qrCode", method = RequestMethod.POST)
    public QRCodeDTO readQRCode(@RequestBody QRCodeDTO qrCodeDTO) throws Exception {
        return userService.readQRCode(qrCodeDTO);
    }

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public List<Book> getAllBook(){
        return userService.getAllBook();
    }

    @RequestMapping(value = "bookStudent", method = RequestMethod.GET)
    public List<BookStudent> getAllBookStudent(){
        return userService.getAllBookStudent();
    }

    @RequestMapping(value = "borrowBook", method = RequestMethod.POST)
    public BookStudent borrowBook(@RequestBody BookDTO bookDTO) throws Exception {
        return userService.borrowBook(bookDTO);
    }

    //add book
    @RequestMapping(value = "book/create", method = RequestMethod.POST)
    public Book addbook(@RequestBody BookDTO bookDTO){
        return userService.addBook(bookDTO);
    }

    //delete book
    @RequestMapping(value = "book/{bookId}/delete", method = RequestMethod.DELETE)
    public void deleteBook(@RequestParam("bookId") int bookId) throws Exception {
        userService.deleteBook(bookId);
    }

    //add Student
    @RequestMapping(value = "student/create", method = RequestMethod.POST)
    public Student addbook(@RequestBody StudentDTO studentDTO){
        return userService.addStudent(studentDTO);
    }

    //delete Student
    @RequestMapping(value = "student/{studentId}/delete", method = RequestMethod.DELETE)
    public void deleteStudent(@RequestParam("studentId") int studentId) throws Exception {
        userService.deleteStudent(studentId);
    }

}
