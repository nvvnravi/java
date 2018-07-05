package stax;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi.Nistala
 */
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource1 {

    private static DataSource1     datasource;
    private ComboPooledDataSource cpds;

    private DataSource1() throws IOException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //loads the jdbc driver
        cpds.setJdbcUrl("jdbc:sqlserver://127.0.0.1:1433;databaseName=hmail;");
        cpds.setUser("nhind");
        cpds.setPassword("nhind01");

        // the settings below are optional -- c3p0 can work with defaults
        cpds.setMinPoolSize(10);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(200);
        cpds.setMaxStatements(180);

    }

    public static DataSource1 getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource1();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

}
