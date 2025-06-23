package cz.vsb.schoolweb.dto;

import cz.vsb.schoolweb.entity.StudentEntity;
import cz.vsb.schoolweb.entity.SubjectEntity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDto {
    private int id;
    //pro nasi vizualni kontrolu - neni nutne, ale potesi
    private StudentDto student;
    private SubjectDto subject;
    //pro pridani cizich klicu - nutne pro manipulaci s tabulkou v DB
    private int studentId;
    private int subjectId;
    private String topic;
    private int mark;
    private LocalDateTime date;
}
