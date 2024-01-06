package com.example.configuration;

import com.example.TestService;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TestConf {

    @Primary
    @Bean
    public TestService testService() {
        return new TestService();
    }

    @Primary
    @PersistenceContext(unitName = "example")
    @Bean
    public LocalContainerEntityManagerFactoryBean routingEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            DataSource dataSource
    ) {
        Map<String, Object> properties = new HashMap<>();
        properties.put(AvailableSettings.HBM2DDL_AUTO, "create-drop");

        return builder
                .dataSource(dataSource)
                .packages("com.example")
                .persistenceUnit("example")
                .properties(properties)
                .build();
    }

}
