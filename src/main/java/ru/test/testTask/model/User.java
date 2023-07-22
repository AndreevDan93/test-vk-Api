package ru.test.testTask.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "user_id should not be empty")
    @Column(name = "user_id")
    private Long vkId;

    @Column(name = "user_f_name")
    private String firstName;

    @Column(name = "user_l_name")
    private String lastName;

    @Column(name = "user_b_date")
    private String date;

    @Column(name = "user_city")
    private String city;

    @Column(name = "user_contacts")
    private String phone;
}
