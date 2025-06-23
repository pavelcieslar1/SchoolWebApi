package cz.vsb.schoolweb.mapper;

import cz.vsb.schoolweb.dto.GradeDto;
import cz.vsb.schoolweb.entity.GradeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {SubjectMapper.class, StudentMapper.class})
public interface GradeMapper {
    GradeEntity toEntity(GradeDto gradeDto);
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "subjectId", source = "subject.id")
    GradeDto toDto (GradeEntity gradeEntity);

    GradeEntity updateEntity(GradeDto gradeDto, @MappingTarget GradeEntity entity);
}
