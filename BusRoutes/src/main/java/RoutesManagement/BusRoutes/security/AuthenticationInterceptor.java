package RoutesManagement.BusRoutes.security;

import RoutesManagement.BusRoutes.Service.User.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String username = request.getHeader("username");
        final String password = request.getHeader("password");
        userService.findAndValidateUser(username,password);
        if (!userService.findByUsername(username).getRole().equalsIgnoreCase("admin")&& !request.getMethod().equalsIgnoreCase("GET"))
            throw new Exception("User is not admin, hence user cannot create or update records");
        return true;
    }
}
