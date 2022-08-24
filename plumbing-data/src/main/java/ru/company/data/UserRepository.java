package ru.company.data;

import org.springframework.data.repository.CrudRepository;
import ru.company.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
