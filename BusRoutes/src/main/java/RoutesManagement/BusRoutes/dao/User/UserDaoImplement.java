package RoutesManagement.BusRoutes.dao.User;

import RoutesManagement.BusRoutes.model.User;
import RoutesManagement.BusRoutes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImplement implements UserDao{
    @Autowired
    UserRepository userRepository;

    public UserDaoImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
        if(userRepository.count() == 0)
        {
            userRepository.save(new User("admin","admin","admin"));
            userRepository.save(new User("user","user","user"));
        }
    }

    @Override
    public User findByUsername(String username) {
    return userRepository.findByUsername(username);
    }
}
