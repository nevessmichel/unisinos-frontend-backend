package unisinos.frontend.backend.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

@Data
public class UserDTO implements Serializable {
    private UUID id;

    private String email;
    private String password;

    private String name;

}
