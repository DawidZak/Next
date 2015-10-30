package com.next.dzejk;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;


/**
 * Klasa konfiguracyjna. Definiuje ziarna zwiazane z konfiguracja polaczenia do
 * bazy H2.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.next", entityManagerFactoryRef = "entityManagerFactory")
@ComponentScan("com.next.dzejk.model")
public class Config {
    /**
     * Sterownik bazy danych.
     */
    
    private String driver = "org.h2.Driver" ;

    /**
     * Adres bazy.
     */
    
    private String url = "jdbc:h2:tcp://localhost/~/Next1;INIT=CREATE SCHEMA IF NOT EXISTS Next;MV_STORE=FALSE;MVCC=FALSE;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE";

    /**
     * Nazwa użytkownika.
     */
    
    private String username = "sa";

    /**
     * Haslo.
     */
    
    private String password = "sa";

    /**
     * Dialekt.
     */
   
    private String dialect ="org.hibernate.dialect.H2Dialect";

    /**
     * Hbm2ddl auto (create / update).
     */
    
    private String hbm2ddlAuto = "create";

    /**
     * Ziarno tworzące entityManagerFactory. Umożliwia polaczenie z baza danych
     * i mapowanie obiektowo-relacyjne.
     *
     * @return LocalContainerEntityManagerFactoryBean zawierajace ustawienia
     *         polaczenia z baza danych.
     */

    
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"com.next.dzejk.model"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        
        return em;
    }

    /**
     * Data Source zawiera konfiguracje polaczenia do bazy danych (adres, login,
     * haslo, sterownik bazy).
     *
     * @return obiekt klasy DataSource zawierajacy konfiguracje polaczenia do
     *         bazy danych.
     */
    @Bean
    public DataSource dataSource() {
    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * Ziarno zarzadzajace transakcjami bazodanowymi.
     *
     * @param emf
     *            - fabryka Entity Managerow - umozliwia powtorne wykorzystanie
     *            EntityManagera w ramach jednej transakcji.
     *
     * @return menadzer transakcji
     */
    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    /**
     * Ziarno konwertujące niskopoziomowe wyjątki bazodanowe na Runtime
     * Exception.
     *
     * @return obiekt klasy PersistenceExceptionTranslationPostProcessor
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * Funkcja definiująca wlasciwosci automatycznego tworzenia bazy danych.
     *
     * @return obiekt Properties zawierajacy wlasciwosci automatycznego
     *         tworzenia bazy.
     */
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }
    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
    	System.out.println("Tiles");
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{
                "/WEB-INF/layouts/tiles.xml",
               //"WEB-INF/views/**/tiles.xml"
        });
        System.out.println("Tiles zdefiniowany");
        tilesConfigurer.setCheckRefresh(true);
        tilesConfigurer.setCompleteAutoload(true);
        return tilesConfigurer;
    }
}