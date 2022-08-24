package ru.company.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.company.entity.Basket;
import ru.company.data.BasketRepository;

@RestController
@RequestMapping(path = "/design",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignBasketController {
    private BasketRepository basketRepo;

    @Autowired
    EntityLinks entityLinks;

    public DesignBasketController(BasketRepository basketRepo) {
        this.basketRepo = basketRepo;
    }

    @GetMapping("/recent")
    public Iterable<Basket> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        return basketRepo.findAll(page).getContent();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Basket postBasket(@RequestBody Basket basket) {
        return basketRepo.save(basket);
    }


    @GetMapping("/{id}")
    public Basket basketById(@PathVariable("id") Long id) {
        Optional<Basket> optBasket = basketRepo.findById(id);
        if (optBasket.isPresent()) {
            return optBasket.get();
        }
        return null;
    }

}

