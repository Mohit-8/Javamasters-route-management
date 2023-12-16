package RoutesManagement.BusRoutes.dao.User;

import RoutesManagement.BusRoutes.model.User;

public interface UserDao {

    User findByUsername(String username);
}
