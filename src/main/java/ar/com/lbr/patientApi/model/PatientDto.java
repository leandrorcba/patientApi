package ar.com.lbr.patientApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDto {

    private String id;
    private String nhc;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;

}
