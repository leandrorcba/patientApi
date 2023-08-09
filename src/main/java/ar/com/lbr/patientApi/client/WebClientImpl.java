package ar.com.lbr.patientApi.client;

import ar.com.lbr.patientApi.exceptions.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientImpl implements WebClientService
{
    @Override
    public String getPatientInfo(String id) {

        String url = "https://hapi.fhir.org/baseR4/Patient/" + id;

        WebClient.Builder builder = WebClient.builder();

        String responseText = builder.build().get().uri(url).retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals, response -> response.bodyToMono(String.class).map(ClientNotFoundException::new))
                .bodyToMono(String.class).block();

        return responseText;
    }
}
