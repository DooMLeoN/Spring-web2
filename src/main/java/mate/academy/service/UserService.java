package mate.academy.service;

import mate.academy.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findByEmail(String Email);

    User add(User user);
}
