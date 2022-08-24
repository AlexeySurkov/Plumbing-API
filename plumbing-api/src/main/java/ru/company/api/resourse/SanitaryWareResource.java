package ru.company.api.resourse;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import org.springframework.hateoas.core.Relation;
import ru.company.entity.SanitaryWare;

@Relation(value="sanitary_ware", collectionRelation="sanitary_wares")
public class SanitaryWareResource extends ResourceSupport {

  @Getter
  private String name;

  @Getter
  private SanitaryWare.Type type;
  
  public SanitaryWareResource(SanitaryWare sanitaryWare) {
    this.name = sanitaryWare.getName();
    this.type = sanitaryWare.getType();
  }

}
