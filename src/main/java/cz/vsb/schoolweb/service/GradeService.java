package cz.vsb.schoolweb.service;

import cz.vsb.schoolweb.dto.GradeDto;
import cz.vsb.schoolweb.entity.GradeEntity;
import cz.vsb.schoolweb.mapper.GradeMapper;
import cz.vsb.schoolweb.repository.GradeRepository;
import cz.vsb.schoolweb.repository.StudentRepository;
import cz.vsb.schoolweb.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    GradeMapper gradeMapper;
    GradeRepository gradeRepository;
    SubjectRepository subjectRepository;
    StudentRepository studentRepository;

    @Autowired
    public GradeService(GradeMapper gradeMapper, GradeRepository gradeRepository, SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.gradeMapper = gradeMapper;
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public List<GradeDto> getAll() {
        List<GradeEntity> allGrades = gradeRepository.findAll();
        List<GradeDto> gradeDtos = new ArrayList<>();
        for (GradeEntity gradeEntity : allGrades) {
            gradeDtos.add(gradeMapper.toDto(gradeEntity));
        }
        return gradeDtos;
    }

    public GradeDto addGrade(GradeDto newGrade){
        GradeEntity entityToInsert = gradeMapper.toEntity(newGrade);
        entityToInsert.setStudent(studentRepository.getReferenceById(newGrade.getStudentId()));
        entityToInsert.setSubject(subjectRepository.getReferenceById(newGrade.getSubjectId()));
        GradeEntity savedEntity = gradeRepository.save(entityToInsert);
        return gradeMapper.toDto(savedEntity);
    }

    public GradeDto editGrade(int gradeId, GradeDto editedGradeDto){
        GradeEntity editedEntity = gradeRepository.findById(gradeId).orElseThrow(EntityNotFoundException::new);
        editedGradeDto.setId(gradeId);
        gradeMapper.updateEntity(editedGradeDto, editedEntity);
        editedEntity.setStudent(studentRepository.getReferenceById(editedGradeDto.getStudentId()));
        editedEntity.setSubject(subjectRepository.getReferenceById(editedGradeDto.getSubjectId()));
        return gradeMapper.toDto(gradeRepository.save(editedEntity));
    }


    public GradeDto getGradeById(int gradeId) {
        GradeEntity grade = gradeRepository.findById(gradeId).orElseThrow(EntityNotFoundException::new);
        return gradeMapper.toDto(grade);
    }

    public GradeDto deleteGrade(int gradeId){
        GradeEntity entityToDelete = gradeRepository.findById(gradeId).orElseThrow(EntityNotFoundException::new);
        GradeDto gradeToReturn = gradeMapper.toDto(entityToDelete);
        gradeRepository.delete(entityToDelete);
        return gradeToReturn;
    }
}
