package RoutesManagement.BusRoutes.Service.User;

import RoutesManagement.BusRoutes.dao.User.UserDao;
import RoutesManagement.BusRoutes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService{
   @Autowired
    UserDao userDao;

    @Override
    public User findAndValidateUser(String username,String password) throws Exception {
        User user = userDao.findByUsername(username);
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new Exception("Invalid username/password supplied");
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
