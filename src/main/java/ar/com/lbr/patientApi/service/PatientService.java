package ar.com.lbr.patientApi.service;

import ar.com.lbr.patientApi.model.PatientDto;

import java.io.IOException;

public interface PatientService {

    PatientDto getPacienteById(String id);
}
