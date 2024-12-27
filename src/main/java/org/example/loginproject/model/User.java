package org.example.loginproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Table(name = "users")
public class User extends BaseModel<Long>{
    @NotBlank(message = "username is required")
    @Size(min = 8,message = "username must have at least eight character")
    private String username;
    @NotBlank(message = "username is required")
    @Size(min = 8,message = "password must have at least eight character")
    private String password;

}
