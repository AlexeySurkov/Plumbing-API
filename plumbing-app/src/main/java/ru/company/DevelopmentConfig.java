package ru.company;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ru.company.data.SanitaryWareRepository;
import ru.company.data.BasketRepository;
import ru.company.data.UserRepository;
import ru.company.entity.Basket;
import ru.company.entity.SanitaryWare;
import ru.company.entity.User;

@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(SanitaryWareRepository repo,
                                        UserRepository userRepo, BasketRepository basketRepo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                SanitaryWare fausetWisent = new SanitaryWare("8723", "Faucet WISENT 22243", SanitaryWare.Type.FAUCET);
                SanitaryWare bathWater = new SanitaryWare("3948", "Bath Water 2*1.3 m", SanitaryWare.Type.BATH);
                SanitaryWare sinkCers = new SanitaryWare("3490", "Sink 0.60m Cersanit GRAND 60", SanitaryWare.Type.SINK);
                SanitaryWare toiletBowl = new SanitaryWare("3242", "Toilet bowl with installation GEBERIT Acanto 50", SanitaryWare.Type.TOILET);
                SanitaryWare faucetWaterFlow = new SanitaryWare("8743", "Faucet WaterFlow2", SanitaryWare.Type.FAUCET);
                SanitaryWare bathComfort = new SanitaryWare("3978", "Bath Comfort 2*0.9 m", SanitaryWare.Type.BATH);
                SanitaryWare sinkFiowjl = new SanitaryWare("3400", "Sink 0.60m Fiowjl 60", SanitaryWare.Type.SINK);
                SanitaryWare toiletIuds = new SanitaryWare("3212", "Toilet IUds 13", SanitaryWare.Type.TOILET);

                repo.save(fausetWisent);
                repo.save(bathWater);
                repo.save(sinkCers);
                repo.save(toiletBowl);
                repo.save(faucetWaterFlow);
                repo.save(bathComfort);
                repo.save(sinkFiowjl);
                repo.save(toiletIuds);

                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

                userRepo.save(new User("habuma", passwordEncoder.encode("password"),
                        "Craig Walls", "123 North Street", "Cross Roads", "TX",
                        "76227", "123-123-1234"));

                Basket basket1 = new Basket();
                basket1.setName("Basket1");
                basket1.setSanitaryWares(Arrays.asList(fausetWisent, faucetWaterFlow, sinkFiowjl));
                basketRepo.save(basket1);

                Basket basket2 = new Basket();
                basket2.setName("Basket2");
                basket2.setSanitaryWares(Arrays.asList(sinkCers, faucetWaterFlow, toiletIuds));
                basketRepo.save(basket2);

                Basket basket3 = new Basket();
                basket3.setName("Basket3");
                basket3.setSanitaryWares(Arrays.asList(bathWater, bathComfort, sinkFiowjl));
                basketRepo.save(basket3);
            }
        };
    }
}
