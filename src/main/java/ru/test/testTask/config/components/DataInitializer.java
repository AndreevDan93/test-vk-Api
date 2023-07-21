package ru.test.testTask.config.components;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;
import ru.test.testTask.service.UserService;

import javax.sql.DataSource;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final DataSource dataSource;
    private final UserService userService;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        if (userService.getAllUsers().isEmpty()) {
            ResourceDatabasePopulator resourceDatabasePopulator
                    = new ResourceDatabasePopulator(false, false,
                    "UTF-8", new ClassPathResource("sql/init_user_info.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
    }
}
