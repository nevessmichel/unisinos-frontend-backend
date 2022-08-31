package unisinos.frontend.backend.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user/create")
    public UserDTO create(@RequestBody UserDTO userDTO){
        return this.userService.toUserDTO(this.userService.saveUser(userDTO));
    }

    @PostMapping("user/login")
    public UserDTO login(@RequestBody UserDTO userDTO){
        return this.userService.toUserDTO(this.userService.login(userDTO));
    }
}
