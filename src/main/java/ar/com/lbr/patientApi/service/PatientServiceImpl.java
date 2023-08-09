package ar.com.lbr.patientApi.service;

import ar.com.lbr.patientApi.client.WebClientService;
import ar.com.lbr.patientApi.mappers.ResponseMapper;
import ar.com.lbr.patientApi.model.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PatientServiceImpl implements PatientService {

    WebClientService client;
    ResponseMapper responseMapper;

    @Autowired
    public PatientServiceImpl(WebClientService client, ResponseMapper responseMapper) {
        this.client = client;
        this.responseMapper = responseMapper;
    }

    @Override
    public PatientDto getPacienteById(String id){

        String clientResponse = client.getPatientInfo(id);

        return responseMapper.mapClientResponse(clientResponse);
    }
}
