package ru.company.api.resourse;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import lombok.Getter;
import ru.company.entity.Basket;

@Relation(value="basket", collectionRelation="baskets")
public class BasketResource extends ResourceSupport {

  private static final SanitaryWareResourceAssembler
            sanitaryWareAssembler = new SanitaryWareResourceAssembler();
  
  @Getter
  private final String name;

  @Getter
  private final Date createdAt;

  @Getter
  private final List<SanitaryWareResource> sanitaryWares;
  
  public BasketResource(Basket basket) {
    this.name = basket.getName();
    this.createdAt = basket.getCreatedAt();
    this.sanitaryWares =
            sanitaryWareAssembler.toResources(basket.getSanitaryWares());
  }
  
}
