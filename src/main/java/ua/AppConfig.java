package ua;

import com.google.gson.internal.LinkedTreeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import ua.crm.DB.UserDetailsServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

@Configuration
@PropertySource("classpath:application.properties")

@EnableTransactionManagement
@EnableWebMvc
@Primary
@EnableJpaRepositories(
        entityManagerFactoryRef = "crmEntityManagerFactory",
        transactionManagerRef = "crmTransactionManager",
        basePackages = {"ua.crm"})

public class AppConfig extends WebMvcConfigurerAdapter {
    @Value("${spring.properties.hibernate.dialect}")
    private String sqlDialect;

    @Value("${spring.properties.hbm2ddl.auto}")
    private String hbm2dllAuto;

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "crmEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource) {

        return builder.dataSource(dataSource).
                properties(additionalProperties()).
                packages("ua.crm").build();
    }

    @Primary
    @Bean(name = "crmTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("crmEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


//    @Bean(name = "crmEntityManagerFactory")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public LocalContainerEntityManagerFactoryBean crmEntityManagerFactory
//            (DataSource dataSource, @Qualifier("crmJpaVendorAdapter") JpaVendorAdapter jpaVendeorAdapter) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setDataSource(dataSource);
//        entityManagerFactory.setJpaVendorAdapter(jpaVendeorAdapter);
//        entityManagerFactory.setJpaProperties(additionalProperties());
//        entityManagerFactory.setPackagesToScan("ua.crm");
//        return entityManagerFactory;
//    }
//
//    @Bean(name = "crmTransactionManager")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public PlatformTransactionManager crmTransactionManager(@Qualifier("crmEntityManagerFactory") EntityManagerFactory emf) {
//        return new JpaTransactionManager(emf);
//    }
//
//    @Bean(name = "crmJpaVendorAdapter")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public JpaVendorAdapter crmJpaVendorAdapter() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setShowSql(true);
//        adapter.setDatabasePlatform(sqlDialect);
//
//        return adapter;
//    }

    @Bean
//    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    private TreeMap<String, String> additionalProperties() {
        TreeMap<String, String> a = new TreeMap<>();
        a.put("hibernate.hbm2ddl.auto", hbm2dllAuto);
        a.put("hibernate.dialect", sqlDialect);
        a.put("hibernate.connection.CharSet","utf-8");
        a.put("hibernate.connection.useUnicode","true");
        a.put("hibernate.connection.characterEncoding","utf-8");
        return a;
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/WEB-INF/pages/css/");
        //.addResourceLocations("file:///C:/Users/Oleg/IdeaProjects/ShopCRM/src/main/resources/static/css/");
    }
}
