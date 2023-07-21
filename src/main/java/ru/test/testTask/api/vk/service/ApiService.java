package ru.test.testTask.api.vk.service;

import ru.test.testTask.api.vk.dto.VkUserDto;

public interface ApiService {
    VkUserDto getUserInfo(String text);
}
