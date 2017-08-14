package laserprint.controller;

import laserprint.DTO.QRCodeDTO;
import laserprint.DTO.UserDTO;
import laserprint.model.Book;
import laserprint.model.BookStudent;
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
    public void readQRCode(@RequestBody QRCodeDTO qrCodeDTO){
        userService.readQRCode(qrCodeDTO);
    }

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public List<Book> getAllBook(){
        return userService.getAllBook();
    }

    @RequestMapping(value = "bookStudent", method = RequestMethod.GET)
    public List<BookStudent> getAllBookStudent(){
        return userService.getAllBookStudent();
    }

}
