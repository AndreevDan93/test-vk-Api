package ru.test.testTask.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.testTask.api.vk.dto.VkUserDto;
import ru.test.testTask.api.vk.service.ApiVkService;
import ru.test.testTask.model.User;
import ru.test.testTask.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ApiVkService apiVkService;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> updateAndGetAllUser() {
        List<Long> vkIds = userRepository.findAllVkId();
        List<VkUserDto> vkUserDtoList = apiVkService.getVkUserInfo(vkIds);
        List<User> users = new ArrayList<>();
        for (VkUserDto vkUserDto: vkUserDtoList) {
            User user = userRepository.getUserByVkId(vkUserDto.getVkId());
            user.setFirstName(vkUserDto.getFirstName());
            user.setLastName(vkUserDto.getLastName());
            user.setDate(vkUserDto.getBDate());
            if (vkUserDto.getCity() != null) {
                user.setCity(vkUserDto.getCity().getTitle());
            }
            user.setPhone(vkUserDto.getMobilePhone());
            userRepository.save(user);
            users.add(user);
        }
        return users;
    }
}
