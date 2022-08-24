package ru.company.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.company.entity.Basket;

public interface BasketRepository
        extends PagingAndSortingRepository<Basket, Long> {
}

