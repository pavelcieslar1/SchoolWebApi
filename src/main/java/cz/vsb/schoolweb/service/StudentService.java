package cz.vsb.schoolweb.service;

import cz.vsb.schoolweb.dto.StudentDto;
import cz.vsb.schoolweb.entity.StudentEntity;
import cz.vsb.schoolweb.mapper.StudentMapper;
import cz.vsb.schoolweb.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    StudentMapper studentMapper;
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        //iter
        for (StudentEntity studentEntity : studentEntities) {
            studentDtos.add(studentMapper.toDto(studentEntity));
        }
        return studentDtos;
    }

    public StudentDto addStudent(StudentDto newStudentDto) {
        StudentEntity studentEntity = studentMapper.toEntity(newStudentDto);
        StudentEntity savedStudent = studentRepository.save(studentEntity);
        return studentMapper.toDto(savedStudent);
    }

    public StudentDto editStudent(StudentDto editedStudent, int studentId){
        if (!studentRepository.existsById(studentId)){
            throw new EntityNotFoundException("Student not found");
        }
        StudentEntity entity = studentMapper.toEntity(editedStudent);
        entity.setId(studentId);
        StudentEntity savedStudent = studentRepository.save(entity);
        return studentMapper.toDto(savedStudent);
    }

    public StudentDto deleteStudent(int studentId){
        StudentEntity entity = studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);
        StudentDto deletedStudentToReturn = studentMapper.toDto(entity);
        studentRepository.delete(entity);
        return deletedStudentToReturn;
    }
}
