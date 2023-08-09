package ar.com.lbr.patientApi.controller;

import ar.com.lbr.patientApi.model.PatientDto;
import ar.com.lbr.patientApi.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/paciente")
public class PatientController {

    @Autowired
    PatientService pacienteService;

    @GetMapping({"/{id}"})
    @Operation(summary = "Get a patient info by the patient id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient found", content = @Content(schema = @Schema(implementation = PatientDto.class))),
            @ApiResponse(responseCode = "404", description = "Patient not found with that id")})
    public ResponseEntity<PatientDto> getPaciente(@PathVariable String id){
        return new ResponseEntity<>(pacienteService.getPacienteById(id), HttpStatus.OK);
    }
}
