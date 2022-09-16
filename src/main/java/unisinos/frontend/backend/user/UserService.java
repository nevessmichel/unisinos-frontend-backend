package unisinos.frontend.backend.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(UserDTO userDTO){
        User user = this.toUser(userDTO);
        try {
            repository.save(user);
            return user;
        }catch (DuplicateKeyException e){
            System.out.println("Email em uso");
            return null;
        }
    }

    public User login(UserDTO userDTO){
        return repository.login(userDTO.getEmail(), userDTO.getPassword());
    }

    public User toUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
