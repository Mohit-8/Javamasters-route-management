package RoutesManagement.BusRoutes.Service.User;

import RoutesManagement.BusRoutes.model.User;

public interface UserService {
    User findAndValidateUser(String username,String password)throws Exception;

    User findByUsername(String username);
}
