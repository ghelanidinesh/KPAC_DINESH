package com.knowledge.admin.configs;

import com.knowledge.admin.constants.KnowledgePackageConstant;
import com.knowledge.admin.constants.KnowledgePackageConstant.KnowledgePackageDatabaseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@PropertySource(KnowledgePackageConstant.CLASSPATH_DB_PROPERTIES_CONSTANT)
public class DataBaseConfiguration {
    private final Environment environment;

    @Autowired
    public DataBaseConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty(KnowledgePackageDatabaseConstants.DB_DRIVER_CLASS_NAME)));
        dataSource.setUrl(environment.getProperty(KnowledgePackageDatabaseConstants.DATABASE_URL));
        dataSource.setUsername(environment.getProperty(KnowledgePackageDatabaseConstants.DATABASE_USERNAME));
        dataSource.setPassword(environment.getProperty(KnowledgePackageDatabaseConstants.DATABASE_PASSWORD));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }
}
