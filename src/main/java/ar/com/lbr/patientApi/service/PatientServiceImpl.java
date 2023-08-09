package ar.com.lbr.patientApi.service;

import ar.com.lbr.patientApi.client.WebClientService;
import ar.com.lbr.patientApi.model.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    WebClientService client;

    @Override
    public PatientDto getPacienteById(String id) {

        String clientResponse = client.getPatientInfo(id);

        return PatientDto.builder()
                .birthDate(LocalDate.now())
                .gender("masculino")
                .id("123456")
                .name("Jose")
                .nhc("465488")
                .surname("Perez")
                .build();
    }
}
