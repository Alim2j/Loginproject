package org.example.loginproject.servlet;

import org.example.loginproject.dto.CreateUserRequest;
import org.example.loginproject.dto.response.SignInResponse;
import org.example.loginproject.model.SignInRequest;
import org.example.loginproject.service.UserService;
import org.example.loginproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateUserRequest createUserRequest=(CreateUserRequest)req.getAttribute("CreateUserRequest");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        SignInRequest signInRequest=SignInRequest.builder().username(username).password(password).build();
        SignInResponse signInResponse =userService.signIn(signInRequest);
        if(signInResponse.getUserId()==null){
            userService.addUser(createUserRequest);
            req.getRequestDispatcher("view/dashboard.jsp").forward(req, resp);
        }else {
            req.setAttribute("error"," username is exist ");
            req.getRequestDispatcher("view/signup.jsp").forward(req, resp);

        }


    }
}
