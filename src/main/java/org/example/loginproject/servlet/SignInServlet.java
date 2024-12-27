package org.example.loginproject.servlet;

import org.example.loginproject.dto.response.SignInResponse;
import org.example.loginproject.model.SignInRequest;
import org.example.loginproject.service.UserService;
import org.example.loginproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private final UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        SignInRequest signInRequest=SignInRequest.builder().username(username).password(password).build();
        SignInResponse signInResponse =userService.signIn(signInRequest);
if(signInResponse.getUserId()!=null){
    HttpSession session=req.getSession(Boolean.FALSE);
    session.setAttribute("userId",signInResponse.getUserId());
    req.getRequestDispatcher("view/dashboard.jsp").forward(req, resp);
}else {
    req.setAttribute("error","Invalid username or password");
    req.getRequestDispatcher("view/error.jsp").forward(req, resp);

}
    }
}
