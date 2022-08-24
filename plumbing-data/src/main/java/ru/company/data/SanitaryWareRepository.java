package ru.company.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.company.entity.SanitaryWare;

@CrossOrigin(origins = "*")
public interface SanitaryWareRepository
        extends CrudRepository<SanitaryWare, String> {
}
