package ar.com.lbr.patientApi.mappers;

import ar.com.lbr.patientApi.json.Json;
import ar.com.lbr.patientApi.model.PatientDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ResponseMapper {

    JsonNode node;

    public PatientDto mapClientResponse(String clientResponse){

        try {
            node = Json.parse(clientResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate birthDate = LocalDate.parse(node.get("birthDate").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return PatientDto.builder()
                .id(node.get("id").asText())
                .name(getName())
                .nhc(getNHC())
                .surname(getSurname())
                .birthDate(birthDate)
                .gender(getGender())
                .build();
    }

    String getSurname(){
        return node.get("name").get(0).get("family").asText();
   }

    String getName(){
        return node.get("name").get(0).get("given").get(0).asText();
    }

    String getNHC(){
        return node.get("identifier").get(0).get("value").asText();
    }

    String getGender(){
        return Gender.fromString(node.get("gender").asText());
    }

}
