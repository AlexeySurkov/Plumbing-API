package ru.company.api.resourse;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import ru.company.api.controller.DesignBasketController;
import ru.company.entity.Basket;

public class BasketResourceAssembler
        extends ResourceAssemblerSupport<Basket, BasketResource> {

    public BasketResourceAssembler() {
        super(DesignBasketController.class, BasketResource.class);
    }

    @Override
    protected BasketResource instantiateResource(Basket basket) {
        return new BasketResource(basket);
    }

    @Override
    public BasketResource toResource(Basket basket) {
        return createResourceWithId(basket.getId(), basket);
    }

}
