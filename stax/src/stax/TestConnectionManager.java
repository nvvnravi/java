/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import static org.junit.Assert.*;
import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ravi.Nistala
 */
public class TestConnectionManager {
    //you application server will call the following two methods for you in production env.

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ConnectionManager.configureConnPool();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        ConnectionManager.shutdownConnPool();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetConnection() {
        Connection conn = ConnectionManager.getConnection();
        assertNotNull(conn);
        ConnectionManager.closeConnection(conn);      //releasing the connection

    }
}
