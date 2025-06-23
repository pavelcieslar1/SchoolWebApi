package cz.vsb.schoolweb.mapper;

import cz.vsb.schoolweb.dto.SubjectDto;
import cz.vsb.schoolweb.entity.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectEntity toEntity(SubjectDto source);


    SubjectDto toDto(SubjectEntity source);
}