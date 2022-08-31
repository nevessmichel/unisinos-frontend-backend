package unisinos.frontend.backend.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private String email;
    private String password;
    private String name;

}
