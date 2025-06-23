package cz.vsb.schoolweb.controller;

import cz.vsb.schoolweb.dto.StudentDto;
import cz.vsb.schoolweb.entity.StudentEntity;
import cz.vsb.schoolweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @GetMapping({"/students", "/students/"})
    public List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping({"/students", "/students/"})
    public StudentDto addStudent(@RequestBody StudentDto studentToAdd) {
        return studentService.addStudent(studentToAdd);
    }

    @PutMapping("/students/{studentId}")
    public StudentDto editStudent(@RequestBody StudentDto editedStudent, @PathVariable int studentId) {
        return studentService.editStudent(editedStudent, studentId);
    }

    @DeleteMapping("/students/{studentId}")
    public StudentDto deleteStudent(@PathVariable int studentId){
        return studentService.deleteStudent(studentId);
    }

}
