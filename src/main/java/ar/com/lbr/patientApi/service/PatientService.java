package ar.com.lbr.patientApi.service;

import ar.com.lbr.patientApi.model.PatientDto;

public interface PatientService {

    PatientDto getPacienteById(String id);
}
