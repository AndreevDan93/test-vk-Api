package ru.test.testTask.service;

import ru.test.testTask.api.vk.dto.VkUserDto;
import ru.test.testTask.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<User> updateAndGetAllUser();
}
