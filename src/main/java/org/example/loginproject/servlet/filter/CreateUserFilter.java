package org.example.loginproject.servlet.filter;

import org.example.loginproject.dto.CreateUserRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class CreateUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        CreateUserRequest createUserRequest = CreateUserRequest.builder().username(username).password(password).build();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CreateUserRequest>> validate = validator.validate(createUserRequest);
        if (validate.isEmpty()) {
            request.setAttribute("CreateUserRequest", createUserRequest);
            filterChain.doFilter(request, response);
        }else {
            PrintWriter writer=response.getWriter();
            for (ConstraintViolation<CreateUserRequest> error : validate) {
writer.println(error.getMessage());
            }
            writer.close();
        }
    }
}
