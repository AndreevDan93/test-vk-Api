package ru.test.testTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.testTask.api.vk.dto.VkUserDto;
import ru.test.testTask.model.User;
import ru.test.testTask.service.UserService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + UserController.USER_CONTROLLER_PATH)
public class UserController {
    public static final String USER_CONTROLLER_PATH = "/users";
    private final UserService userService;

    @GetMapping()
    public List<User> getUserByVkId() {
        return userService.updateAndGetAllUser();
    }
}
