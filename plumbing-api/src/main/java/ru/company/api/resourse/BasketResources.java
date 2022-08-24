package ru.company.api.resourse;

import java.util.List;

import org.springframework.hateoas.Resources;

public class BasketResources extends Resources<BasketResources> {
  public BasketResources(List<BasketResources> tacoResources) {
    super(tacoResources);
  }
}