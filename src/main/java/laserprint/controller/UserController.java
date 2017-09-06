package laserprint.controller;

import laserprint.DTO.BookDTO;
import laserprint.DTO.QRCodeDTO;
import laserprint.DTO.StudentDTO;
import laserprint.DTO.UserDTO;
import laserprint.model.*;
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

    @RequestMapping(value = "bookStudent/{id}/delete", method = RequestMethod.DELETE)
    public void deleteBookStudent(@PathVariable("id") int id) throws Exception {
        userService.deleteBookStudent(id);
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
    public void deleteBook(@PathVariable("bookId") int bookId) throws Exception {
        userService.deleteBook(bookId);
    }

    //add Student
    @RequestMapping(value = "student/create", method = RequestMethod.POST)
    public Student addbook(@RequestBody StudentDTO studentDTO) throws Exception {
        return userService.addStudent(studentDTO);
    }

    //delete Student
    @RequestMapping(value = "student/{studentId}/delete", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("studentId") int studentId) throws Exception {
        userService.deleteStudent(studentId);
    }

    //get all student
    @RequestMapping(value = "student", method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        return userService.getAllStudent();
    }

    //tra sach
    @RequestMapping(value = "traSach", method = RequestMethod.POST)
    public void traSach(@RequestBody List<BookDTO> list){
        userService.traSach(list);
    }

    //get all book student of student
    @RequestMapping(value = "bookStudent/{studentId}", method = RequestMethod.GET)
    public List<BookStudent> getAllBookStudentOfStudent(@PathVariable("studentId") int studentId){
        return userService.getAllBookStudentOfStudent(studentId);
    }

    //qrcode naptien
    @RequestMapping(value = "qrcode/naptien", method = RequestMethod.POST)
    public void readQRCodeNapTien(@RequestBody QRCodeDTO qrCodeDTO) throws Exception {
        userService.readQRCodeNapTien(qrCodeDTO);
    }

    //them tien gui xe
    @RequestMapping(value = "tienXe/them", method = RequestMethod.POST)
    public void napTien(@RequestBody StudentDTO studentDTO){
        userService.napTien(studentDTO);
    }

    @RequestMapping(value = "qrcode/checkinGuiXe", method = RequestMethod.POST)
    public void checkinGuiXe(@RequestBody QRCodeDTO qrCodeDTO){
        userService.checkinGuiXe(qrCodeDTO);
    }

    @RequestMapping(value = "qrcode/checkoutGuiXe", method = RequestMethod.POST)
    public void checkoutGuiXe(@RequestBody QRCodeDTO qrCodeDTO){
        userService.checkoutGuiXe(qrCodeDTO);
    }

    @RequestMapping(value = "guiXe", method = RequestMethod.GET)
    public List<GuiXe> getAllGuiXe(){
        return userService.getAllGuiXe();
    }

    @RequestMapping(value = "muctienguixe", method = RequestMethod.GET)
    public UserDTO xemMucTienGuiXe(){
        return userService.xemMucTienGuiXe();
    }

    @RequestMapping(value = "thayDoiMucTienGuiXe/{cash}", method = RequestMethod.POST)
    public void thayDoiMucTienGuiXe(@PathVariable("cash") String cash){
        userService.thayDoiMucTienGuiXe(cash);
    }


}
