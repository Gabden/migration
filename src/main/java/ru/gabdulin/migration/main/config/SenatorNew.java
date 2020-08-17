package ru.gabdulin.migration.main.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = "ru.gabdulin.migration.main.repos.newa", entityManagerFactoryRef = "newEntityManager", transactionManagerRef = "newTransactionManager")
public class SenatorNew {
    @Value("${MYSQL_HOST}")
    private String dbUrl;
    @Value("${SENATOR_DB_LOGIN}")
    private String username;
    @Value("${SENATOR_DB_PASSWORD}")
    private String password;

    @Bean
    public DataSource newDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://" + dbUrl + ":3306/testnew?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setPassword(password);
        dataSource.setUsername(username);
                return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean newEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(newDataSource());
        em.setPackagesToScan("ru.gabdulin.migration.main.models.newer");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public PlatformTransactionManager newTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(newEntityManager().getObject());
        return transactionManager;
    }
}
