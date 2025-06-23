package cz.vsb.schoolweb.controller;

import cz.vsb.schoolweb.dto.SubjectDto;
import cz.vsb.schoolweb.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping({"/subjects", "/subjects/"})
    public SubjectDto addSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);
    }

    @GetMapping({"/subjects", "/subjects/"})
    public List<SubjectDto> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping("/subjects/{subjectId}")
    public SubjectDto getSubject(@PathVariable Integer subjectId) {
        return subjectService.getSubject(subjectId);
    }
    @PutMapping("/subjects/{subjectId}")
    public SubjectDto editSubject(@PathVariable Integer subjectId, @RequestBody SubjectDto subjectDto){
        return subjectService.editSubject(subjectId, subjectDto);
    }
    @DeleteMapping("/subjects/{subjectId}")
    public SubjectDto deleteSubject(@PathVariable int subjectId){
        return subjectService.removeSubject(subjectId);
    }
}

