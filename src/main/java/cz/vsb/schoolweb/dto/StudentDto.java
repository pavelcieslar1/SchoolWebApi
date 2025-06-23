package cz.vsb.schoolweb.dto;

import lombok.*;

import java.time.LocalDate;

@Data
//anotace @Data obsahuje:
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int Id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
