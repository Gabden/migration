package ru.gabdulin.migration.main.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = "ru.gabdulin.migration.main.repos.old", entityManagerFactoryRef = "oldEntityManager", transactionManagerRef = "oldTransactionManager")
public class SenatorOld {
    @Value("${MYSQL_HOST}")
    private String dbUrl;
    @Value("${SENATOR_DB_LOGIN}")
    private String username;
    @Value("${SENATOR_DB_PASSWORD}")
    private String password;

    @Primary
    @Bean
    public DataSource oldDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://" + dbUrl + ":3306/bd?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        return dataSource;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean oldEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(oldDataSource());
        em.setPackagesToScan("ru.gabdulin.migration.main.models.old");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean
    public PlatformTransactionManager oldTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(oldEntityManager().getObject());
        return transactionManager;
    }
}
