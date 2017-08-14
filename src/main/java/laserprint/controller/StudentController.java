package laserprint.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import laserprint.DTO.StudentDTO;
import laserprint.model.*;
import laserprint.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Trung on 7/8/2016.
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    //Show all student information by school
//    @RequestMapping(value="/student", method = RequestMethod.GET)
//    public List<HashMap<String, String>> getAllInfo(HttpServletRequest request){
//        String token = request.getHeader("auth-token");
//        return (List<HashMap<String, String>>) studentService.getAllInfo(token);
//    }

//    //show all student
//    @RequestMapping(value = "student/all", method = RequestMethod.GET)
//    public Page<Student> getAllStudent(Pageable pageable){
//        return studentService.getAllStudent(pageable);
//    }
//
//    //show all student no lectutrers
//    @RequestMapping(value = "student/no/lectutrers", method = RequestMethod.GET)
//    public List<Student> getAllStudentNoLecturers(){
//        return studentService.getAllStudentNoLecturers();
//    }
//
//    //get student bu internship term
//    @RequestMapping(value = "student/internshipTerm/{internshipTermId}", method = RequestMethod.GET)
//    public List<Student> getStudentByInternshipTerm(@PathVariable("internshipTermId") int internshipTermId){
//        return studentService.getStudentByInternshipTerm(internshipTermId);
//    }
//
//    //get student by lecterersId and last internship term
//    @RequestMapping(value = "lecturers/{lecturersId}/student", method = RequestMethod.GET)
//    public List<Student> getStudentByLecturersId(@PathVariable("lecturersId") int lecturersId){
//        return studentService.getStudentByLecturersId(lecturersId);
//    }
//
//    //get student by internship term no lecturers
//    @RequestMapping(value = "student/internshipTerm/no/lecturers", method = RequestMethod.GET)
//    public List<Student> getAllStudentByInternshipTermAndNOLecturers(){
//        return studentService.getAllStudentByInternshipTermAndNOLecturers();
//    }
//
//    //getCountStudentNoFollow
//    @RequestMapping(value = "getCountStudentNoFollow", method = RequestMethod.GET)
//    public StudentDTO getCountStudentNoFollow(){
//        return studentService.getCountStudentNoFollow();
//    }
//
//    //get student no internship term
//    @RequestMapping(value = "student/no/internshipTerm", method = RequestMethod.GET)
//    public List<Student> getStudentNoInternshipTerm(){
//        return studentService.getStudentNoInternshipTerm();
//    }
//
//    //delete student
//    @RequiredRoles(Role.ADMIN)
//    @RequestMapping(value = "student/delete/{studentId}", method = RequestMethod.DELETE)
//    public void deleteStudent(@PathVariable("studentId") int studentId){
//        studentService.deleteStudent(studentId);
//    }
////    //Create
////    @RequiredRoles({Role.STUDENT,Role.ADMIN})
////    @RequestMapping(value="/user/{userId}/student", method = RequestMethod.POST)
////    public Student createStudent(@PathVariable("userId") int userId, @RequestBody StudentDTO studentDTO){
////        return studentService.createStudent(userId, studentDTO);
////    }
//
//    //Show a student
//    @RequestMapping(value="student/{studentId}",method = RequestMethod.GET)
//    public Student findStudent(@PathVariable("studentId") int studentId, HttpServletRequest request) {
//        String token = request.getHeader("auth-token");
//        return studentService.findStudent(studentId, token);
//    }
//
//    //get student by student code
//    @RequestMapping(value = "student/studentCode", method = RequestMethod.POST)
//    public List<InfoBySchool> findStudentByStudentCode(@RequestBody InfoBySchoolDTO infoBySchoolDTO){
//        return studentService.findStudentByStudentCode(infoBySchoolDTO);
//    }
//
//    @RequiredRoles(Role.ADMIN)
//    @RequestMapping(value = "internshipTerm/add/student", method = RequestMethod.PUT)
//    public void addAllStudentToInternshipTerm(){
//        studentService.addAllStudentToInternshipTerm();
//    }
//
//    //Student search partner
//    @RequiredRoles({Role.STUDENT, Role.ADMIN})
//    @RequestMapping(value="searchPartner", method = RequestMethod.POST)
//    public List<Partner> searchPartner(@RequestBody PartnerDTO partnerDTO){
//        return studentService.searchPartner(partnerDTO);
//    }
//
//    //Student search post description
//    @RequiredRoles({Role.STUDENT, Role.ADMIN})
//    @RequestMapping(value="searchDescription", method = RequestMethod.POST)
//    public List<Post> searchDescription(@RequestBody PostDTO postDTO){
//        return studentService.searchDescription(postDTO);
//    }
//
//    //Student search post by content
//    @RequiredRoles({Role.STUDENT, Role.ADMIN})
//    @RequestMapping(value="searchContent", method = RequestMethod.POST)
//    public List<Post> searchContent(@RequestBody PostDTO postDTO){
//        return studentService.searchContent(postDTO);
//    }
//
//    //show info of a student
//    @RequiredRoles({Role.ADMIN,Role.STUDENT,Role.VIP_PARTNER})
//    @RequestMapping(value = "/studentInfo",method = RequestMethod.GET)
//    public Student getStudentInfo(HttpServletRequest request){
//        String token = request.getHeader("auth-token");
//        return studentService.getStudentInfo(token);
//    }
//
//    //edit info of a student
//    @RequiredRoles(Role.STUDENT)
//    @RequestMapping(value = "/studentInfo",method = RequestMethod.PUT)
//    public Student editStudentInfo(@RequestBody StudentDTO studentDTO, HttpServletRequest request) throws IOException {
//        String token = request.getHeader("auth-token");
//        return studentService.editStudentInfo(studentDTO,token);
//    }
//
//    //change avatar
//    @RequiredRoles(Role.STUDENT)
//    @RequestMapping(value = "changeAva", method = RequestMethod.PUT)
//    public void changeAva(@RequestBody StudentDTO studentInfoDTO, HttpServletRequest request) throws IOException {
//        String token = request.getHeader("auth-token");
//        studentService.changeAva(studentInfoDTO, token);
//    }

    //delete info of a student
//    @RequiredRoles({Role.STUDENT,Role.ADMIN})
//    @RequestMapping(value = "/studentInfo/{id}",method = RequestMethod.DELETE)
//    public void deleteStudentInfo(@PathVariable("id") int id, HttpServletRequest request){
//        String token = request.getHeader("auth-token");
//        studentService.deleteStudentInfo(id, token);
//    }
}
