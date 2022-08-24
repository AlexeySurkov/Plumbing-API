package ru.company.restclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import ru.company.entity.SanitaryWare;

@Service
@Slf4j
public class PlumbingClient {

    private RestTemplate rest;

    public PlumbingClient(RestTemplate rest) {
        this.rest = rest;
    }

    public SanitaryWare getSanitaryWareById(String sanitaryWareId) {
        return rest.getForObject("http://localhost:8080/sanitarywares/{id}",
                SanitaryWare.class, sanitaryWareId);
    }

    public List<SanitaryWare> getAllSanitaryWares() {
        return rest.exchange("http://localhost:8080/sanitarywares",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<SanitaryWare>>() {
                        })
                .getBody();
    }

    public void updateSanitaryWare(SanitaryWare sanitaryWare) {
        rest.put("http://localhost:8080/sanitarywares/{id}",
                sanitaryWare, sanitaryWare.getId());
    }

    public SanitaryWare createSanitaryWare(SanitaryWare sanitaryWare) {
        return rest.postForObject("http://localhost:8080/sanitarywares",
                sanitaryWare, SanitaryWare.class);
    }

    public void deleteSanitaryWare(SanitaryWare sanitaryWare) {
        rest.delete("http://localhost:8080/sanitarywares/{id}",
                sanitaryWare.getId());
    }
}
