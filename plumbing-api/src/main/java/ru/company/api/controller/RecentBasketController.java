package ru.company.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import ru.company.api.resourse.BasketResource;
import ru.company.api.resourse.BasketResourceAssembler;
import ru.company.data.BasketRepository;
import ru.company.entity.Basket;

@RestController
@RepositoryRestController
public class RecentBasketController {

  private BasketRepository basketRepo;

  public RecentBasketController(BasketRepository basketRepo) {
    this.basketRepo = basketRepo;
  }

  @GetMapping(path="/baskets/recent", produces="application/hal+json")
  public ResponseEntity<Resources<BasketResource>> recentTacos() {
    PageRequest page = PageRequest.of(
                          0, 12, Sort.by("createdAt").descending());
    List<Basket> tacos = basketRepo.findAll(page).getContent();

    List<BasketResource> basketResources =
        new BasketResourceAssembler().toResources(tacos);
    Resources<BasketResource> recentResources =
            new Resources<BasketResource>(basketResources);
    
    recentResources.add(
        linkTo(methodOn(RecentBasketController.class).recentTacos())
            .withRel("recents"));
    return new ResponseEntity<>(recentResources, HttpStatus.OK);
  }

}
