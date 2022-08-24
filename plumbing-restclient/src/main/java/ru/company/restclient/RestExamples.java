package ru.company.restclient;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import ru.company.entity.SanitaryWare;


@SpringBootConfiguration
@ComponentScan
@Slf4j
public class RestExamples {

    public static void main(String[] args) {
        SpringApplication.run(RestExamples.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner fetchSanitaryWare(PlumbingClient plumbingClient) {
        return args -> {
            log.info(plumbingClient.getSanitaryWareById("8723").toString());
            List<SanitaryWare> sanitaryWares = plumbingClient.getAllSanitaryWares();

            for (SanitaryWare sanitaryWare : sanitaryWares) {
                log.info("   - " + sanitaryWare);
            }
        };
    }

    @Bean
    public CommandLineRunner putSanitaryWare(PlumbingClient plumbingClient) {
        return args -> {
            SanitaryWare before = plumbingClient.getSanitaryWareById("8723");
            log.info(before.toString());

            plumbingClient.updateSanitaryWare(new SanitaryWare("8723", "11111", SanitaryWare.Type.BATH));
            SanitaryWare after = plumbingClient.getSanitaryWareById("8723");
            log.info(after.toString());
        };
    }

    @Bean
    public CommandLineRunner addSanitaryWare(PlumbingClient plumbingClient) {
        return args -> {
            plumbingClient.createSanitaryWare(new SanitaryWare("12345", "1111111111", SanitaryWare.Type.FAUCET));
            log.info(plumbingClient.getSanitaryWareById("12345").toString());
        };
    }


    @Bean
    public CommandLineRunner deleteSanitaryWare(PlumbingClient plumbingClient) {
        return args -> {
            SanitaryWare sanitaryWare = new SanitaryWare("12345", "1111111111", SanitaryWare.Type.FAUCET);
            plumbingClient.createSanitaryWare(sanitaryWare);

            sanitaryWare = plumbingClient.getSanitaryWareById("12345");
            log.info(sanitaryWare.toString());

            plumbingClient.deleteSanitaryWare(sanitaryWare);
            sanitaryWare = plumbingClient.getSanitaryWareById("12345");
            log.info(sanitaryWare.toString());
        };
    }
}
