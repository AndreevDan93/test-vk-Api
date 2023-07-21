package ru.test.testTask.api.vk.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VkUserDto {
    @JsonProperty("id")
    private Long vkId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("bdate")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d.M.yyyy")
    private String bDate;
    private City city;
    @JsonProperty("home_phone")
    private String homePhone;
    @JsonProperty("mobile_phone")
    private String mobilePhone;
    @JsonProperty("can_access_closed")
    private boolean canAccessClosed;
    @JsonProperty("is_closed")
    private boolean isClosed;
    private String deactivated;

}
