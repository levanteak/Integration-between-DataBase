package com.example.intergration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "kz.arta.integration.repository.from",
        entityManagerFactoryRef = "fromEntityManagerFactory",
        transactionManagerRef = "fromTransactionManager"
)
public class FromDbConfig {

    @Bean
    @ConfigurationProperties(prefix = "from.datasource")
    public DataSource fromDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean fromEntityManagerFactory(
            @Qualifier("fromDataSource") DataSource dataSource) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSource);
            setPackagesToScan("kz.arta.integration.entity.from");
            setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        }};
    }

    @Bean
    public PlatformTransactionManager fromTransactionManager(
            @Qualifier("fromEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}

