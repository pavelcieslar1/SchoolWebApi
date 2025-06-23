package cz.vsb.schoolweb.service;
import cz.vsb.schoolweb.dto.SubjectDto;
import cz.vsb.schoolweb.mapper.SubjectMapper;
import cz.vsb.schoolweb.entity.SubjectEntity;
import cz.vsb.schoolweb.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;
    private SubjectMapper subjectMapper;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    public SubjectDto addSubject(SubjectDto subjectDto) {
        SubjectEntity subjectToSave = subjectRepository.save(subjectMapper.toEntity(subjectDto));
        return subjectMapper.toDto(subjectToSave);
    }


    public List<SubjectDto> getSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<SubjectDto> allSubjects = new ArrayList<>();
        for(SubjectEntity subject:subjectEntities){
            allSubjects.add(subjectMapper.toDto(subject));
        }
        return allSubjects;
    }


    public SubjectDto getSubject(int subjectId) {
        SubjectEntity subject = subjectRepository.getReferenceById(subjectId);
        return subjectMapper.toDto(subject);
    }


    public SubjectDto editSubject(int subjectId, SubjectDto subjectDto) {
        if (!subjectRepository.existsById(subjectId)){
            throw new EntityNotFoundException("Subject with id " + subjectId + "was not found");
        }
        SubjectEntity entity = subjectMapper.toEntity(subjectDto);
        entity.setId(subjectId);
        SubjectEntity saved = subjectRepository.save(entity);
        return subjectMapper.toDto(saved);
    }


    public SubjectDto removeSubject(int subjectId) {
        SubjectEntity subjectToRemove = subjectRepository.findById(subjectId).orElseThrow(EntityNotFoundException::new);
        SubjectDto model = subjectMapper.toDto(subjectToRemove);
        subjectRepository.delete(subjectToRemove);
        return model;
    }
}
