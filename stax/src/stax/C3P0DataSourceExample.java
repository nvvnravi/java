/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

/**
 *
 * @author Ravi.Nistala
 */
import java.beans.PropertyVetoException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0DataSourceExample {
    


    public static void main(String[] args) throws PropertyVetoException, SQLException, IOException, InterruptedException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));

        C3P0DataSourceExample example = new C3P0DataSourceExample();
        int count = 0;

        while (count <= 1000) {
            example.intouch2SelectMethod(out);
            Thread.sleep(1000);
            example.intouch2InsertMethod(out);
            Thread.sleep(1000);
            example.intouch2UpdateMethod(out);
            Thread.sleep(1000);
            example.intouch2DeleteMethod(out);
            Thread.sleep(1000);
            count++;
        }
        
        out.close();

    }

    private void intouch2SelectMethod(PrintStream out) throws PropertyVetoException, SQLException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DataSource.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from audit_events");
            while (resultSet.next()) {
                out.println("id: " + resultSet.getString("id"));
                out.println("event: " + resultSet.getString("event"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void intouch2InsertMethod(PrintStream out) throws PropertyVetoException, SQLException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DataSource.getInstance().getConnection();
            statement = connection.createStatement();
            String insertStatement = "INSERT INTO [dbo].[USER_PREFERENCES] "
                    + "([USERNAME] ,[KEYWORD] ,[PREF_VALUE]) "
                    + " VALUES('testDBPerf@gdit.ihs.gov' ,'emailAddress','testDBPerf@gdit.ihs.gov')";

            boolean result = statement.execute(insertStatement);

            out.println("intouch2InsertMethod result is : " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void intouch2UpdateMethod(PrintStream out) throws PropertyVetoException, SQLException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DataSource.getInstance().getConnection();
            statement = connection.createStatement();
            String updateStatement = "UPDATE USER_PREFERENCES SET KEYWORD = 'firstName',PREF_VALUE = 'firstName' WHERE USERNAME = 'testDBPerf@gdit.ihs.gov' ";

            boolean result = statement.execute(updateStatement);
            out.println("intouch2UpdateMethod result is : " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void intouch2DeleteMethod(PrintStream out) throws PropertyVetoException, SQLException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DataSource.getInstance().getConnection();
            statement = connection.createStatement();
            String updateStatement = "delete from USER_PREFERENCES  WHERE USERNAME = 'testDBPerf@gdit.ihs.gov' ";

            boolean result = statement.execute(updateStatement);
            out.println("intouch2DeleteMethod result is : " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
