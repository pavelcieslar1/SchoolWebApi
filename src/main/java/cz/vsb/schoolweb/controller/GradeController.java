package cz.vsb.schoolweb.controller;

import cz.vsb.schoolweb.dto.GradeDto;
import cz.vsb.schoolweb.service.GradeService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {
    GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }


    @GetMapping({"/grades", "/grades/"})
    public List<GradeDto> getAllGrades(){
        return gradeService.getAll();
    }

    @GetMapping("/grades/{gradeId}")
    public GradeDto getGrade(@PathVariable  @Parameter(name = "gradeId", description = "Id of the grade to show", example = "1") int gradeId){
        return gradeService.getGradeById(gradeId);
    }


    @PostMapping({"/grades", "/grades/"})
    public GradeDto addGrade(@RequestBody GradeDto gradeDto){
        return gradeService.addGrade(gradeDto);
    }

    @PutMapping({"/grades/{gradeId}"})
    public GradeDto updateGrade(@PathVariable int gradeId, @RequestBody GradeDto updatedGrade){
        return gradeService.editGrade(gradeId, updatedGrade);
    }

    @DeleteMapping("/grades/{gradeId}")
    public GradeDto removeGrade(@PathVariable int gradeId){
        return gradeService.deleteGrade(gradeId);
    }
}
