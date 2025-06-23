package cz.vsb.schoolweb.repository;

import cz.vsb.schoolweb.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<GradeEntity, Integer> {
}
