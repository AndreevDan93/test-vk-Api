package ru.test.testTask.api.vk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.test.testTask.api.vk.dto.VkUserDto;

import java.util.List;

@Component
public class ApiUtils {

    @Autowired
    public ApiUtils(@Value("${vk-api-url}") String baseVkUrl) {
        Unirest.config().defaultBaseUrl(baseVkUrl);
    }

    public List<VkUserDto> get(String requestPath) {
        String response = Unirest.get(requestPath)
                .asJson().getBody().getObject().get("response").toString();
        System.out.println(response);
        Unirest.shutDown();
        ObjectMapper objectMapper = new ObjectMapper();
        List<VkUserDto> vkUserDto = null;
        try {
            vkUserDto = objectMapper.readValue(response,
                    new TypeReference<List<VkUserDto>>() {
                    });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return vkUserDto;
    }

}
