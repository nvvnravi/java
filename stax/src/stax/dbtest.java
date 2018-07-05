/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.sql.Connection;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Ravi.Nistala
 */
public class dbtest {

    public static void main(String[] args) throws Exception {

        ConnectionManager.configureConnPool();
        Connection conn = ConnectionManager.getConnection();
        assertNotNull(conn);
        ConnectionManager.closeConnection(conn);

        ConnectionManager.shutdownConnPool();
    }

}
