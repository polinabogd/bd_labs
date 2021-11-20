package bgd.controller;

import bgd.domain.User;
import bgd.dto.UserDTO;
import bgd.mapper.AbstractMapper;
import bgd.mapper.UserMapper;
import bgd.service.AbstractService;
import bgd.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users")
@RestController
@AllArgsConstructor
public class UserController extends AbstractController<User, UserDTO, Integer> {
    private final UserService userService;
    private final UserMapper userMapper;


    @Override
    protected AbstractService<User, Integer> getService() {
        return userService;
    }

    @Override
    protected AbstractMapper<User, UserDTO> getMapper() {
        return userMapper;
    }
}
