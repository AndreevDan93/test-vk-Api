package ru.test.testTask.api.vk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.testTask.api.vk.ApiUtils;
import ru.test.testTask.api.vk.dto.VkUserDto;

import java.util.List;

@Service
@Transactional
public class ApiVkService {
    private static final String GET_USER_INFO_METHOD = "/method/users.get";
    private final String accessToken;
    private final String apiVersion;
    private final String fields;
    private final ApiUtils apiUtils;

    @Autowired
    public ApiVkService(@Value("${vk-api-access_token}") String accessToken,
                        @Value("${vk-api-version}") String apiVersion,
                        @Value("${vk-api-fields}") String fields,
                        ApiUtils apiUtils) {
        this.accessToken = accessToken;
        this.apiVersion = apiVersion;
        this.fields = fields;
        this.apiUtils = apiUtils;

    }

    public List<VkUserDto> getVkUserInfo(List<Long> vkIds) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < vkIds.size(); i++) {
            stringBuilder.append(vkIds.get(i));
            if (i != vkIds.size() - 1) {
                stringBuilder.append(",");
            }
        }
        String ids = stringBuilder.toString();

        String request = String.format(
                "%s?user_ids=%s&fields=%s&access_token=%s&v=%s",
                GET_USER_INFO_METHOD,
                ids,
                fields,
                accessToken,
                apiVersion
        );
        return apiUtils.get(request);
    }
}
