package ru.company.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import ru.company.entity.Basket;

@Configuration
public class SpringDataRestConfiguration {

  @Bean
  public ResourceProcessor<PagedResources<Resource<Basket>>>
    basketProcessor(EntityLinks links) {

    return new ResourceProcessor<PagedResources<Resource<Basket>>>() {
      @Override
      public PagedResources<Resource<Basket>> process(
                          PagedResources<Resource<Basket>> resource) {
        resource.add(
            links.linkFor(Basket.class)
                 .slash("recent")
                 .withRel("recents"));
        return resource;
      }
    };
  }
  
}
