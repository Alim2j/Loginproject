package org.example.loginproject.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
@Builder
public class CreateUserRequest {
    @NotBlank(message = "username is required")
    @Size(min = 8,message = "username must have at least eight character")
    private String username;
    @NotBlank(message = "password is required")
    @Size(min = 8,message = "password must have at least eight character")
    private String password;
}
