package cz.vsb.schoolweb.mapper;

import cz.vsb.schoolweb.dto.StudentDto;
import cz.vsb.schoolweb.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toEntity (StudentDto studentDto);
    StudentDto toDto (StudentEntity studentEntity);
}
