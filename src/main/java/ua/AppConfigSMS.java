package ua;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.TreeMap;

@Configuration
@PropertySource("classpath:application.properties")

@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "smsEntityManagerFactory",
        transactionManagerRef = "smsTransactionManager",
        basePackages = {"ua.turbosms"})

public class AppConfigSMS {
    @Value("${spring.SMS.properties.hibernate.dialect}")
    private String sqlDialect;

    @Value("${spring.SMS.properties.hbm2ddl.auto}")
    private String hbm2dllAuto;


    @Bean(name = "smsDataSource")
    @ConfigurationProperties(prefix = "spring.SMS.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "smsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("smsDataSource") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .properties(additionalProperties())
                .packages("ua.turbosms")
//                .persistenceUnit("turbosms")
                .build();
    }


    @Bean(name = "smsTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("smsEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


    private TreeMap<String, String> additionalProperties() {
        TreeMap<String, String> a = new TreeMap<>();
        a.put("hibernate.hbm2ddl.auto", hbm2dllAuto);
        a.put("hibernate.dialect", sqlDialect);
        return a;

    }

}
