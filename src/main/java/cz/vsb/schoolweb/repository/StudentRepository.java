package cz.vsb.schoolweb.repository;

import cz.vsb.schoolweb.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
