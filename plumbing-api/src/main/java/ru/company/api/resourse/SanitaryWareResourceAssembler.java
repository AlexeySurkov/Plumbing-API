package ru.company.api.resourse;

import org.springframework.hateoas.core.Relation;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import ru.company.api.controller.SanitaryWareController;
import ru.company.entity.SanitaryWare;

@Relation(value="sanitary_ware", collectionRelation="sanitary_wares")
class SanitaryWareResourceAssembler extends
          ResourceAssemblerSupport<SanitaryWare, SanitaryWareResource> {

  public SanitaryWareResourceAssembler() {
    super(SanitaryWareController.class, SanitaryWareResource.class);
  }

  @Override
  public SanitaryWareResource toResource(SanitaryWare sanitaryWare) {
    return createResourceWithId(sanitaryWare.getId(), sanitaryWare);
  }
  
  @Override
  protected SanitaryWareResource instantiateResource(
          SanitaryWare sanitaryWare) {
    return new SanitaryWareResource(sanitaryWare);
  }

}