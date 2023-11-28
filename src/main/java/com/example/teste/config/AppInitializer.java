//package com.example.teste.config;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.Resource;
//import jakarta.ejb.Singleton;
//import jakarta.ejb.Startup;
//import jakarta.inject.Inject;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import liquibase.Liquibase;
//import liquibase.exception.LiquibaseException;
//
//import javax.sql.ConnectionPoolDataSource;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//@Singleton
//public class AppInitializer {
//
////    @Inject
////    private Liquibase liquibase;
//
//    @PersistenceContext
//    DataSource dataSource;
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @PostConstruct
//    public void init() throws LiquibaseException, SQLException {
//        dataSource.getConnection();
//        Connection con = Liquibase.getConnection(dataSource);
////        liquibase.update("");
//    }
//}
