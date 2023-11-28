package com.example.teste.config;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class Setup {

    private static final String CHANGELOG_FILE = "liquibase/changelog-master.xml";

    @Resource
    private DataSource ds;

    @PostConstruct
    protected void bootstrap() {
        ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(getClass().getClassLoader());
        try (Connection connection = ds.getConnection()) {
            JdbcConnection jdbcConnection = new JdbcConnection(connection);
            Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcConnection);

            Liquibase liquiBase = new Liquibase(CHANGELOG_FILE, resourceAccessor, db);
            liquiBase.update();
        } catch (SQLException | LiquibaseException e) {
            e.getMessage();
            e.printStackTrace();
        }

    }
}
