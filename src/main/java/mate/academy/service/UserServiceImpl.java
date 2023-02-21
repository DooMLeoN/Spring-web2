package mate.academy.service;

import mate.academy.dao.UserDao;
import mate.academy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> findByEmail(String Email) {

        return userDao.findByEmail(Email);
    }

    @Override
    public User add(User user) {
        return userDao.add(user);
    }
}
