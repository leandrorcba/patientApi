package ar.com.lbr.patientApi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String mensaje;
}
