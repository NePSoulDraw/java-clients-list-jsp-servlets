
package data;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class SqlConnection {
    
    /* Database SQL code to create SCHEMA and table used --> CREATE SCHEMA `client_management`;
                                                            
                                                             CREATE TABLE `client_management`.`clients` (
                                                                `client_id` INT NOT NULL AUTO_INCREMENT,
                                                                `name` VARCHAR(45) NOT NULL,
                                                                `surname` VARCHAR(45) NOT NULL,
                                                                `email` VARCHAR(45) NOT NULL,
                                                                `phone` INT NULL DEFAULT NULL,
                                                                `balance` DOUBLE NOT NULL,
                                                                PRIMARY KEY (`client_id`)); */
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/client_management?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    private static final String JDBC_USER = "root";
    
    private static final String JDBC_PASSWORD = "admin";
    
    private static BasicDataSource dataSource;
    
    public static DataSource getDataSource(){
     
        if(dataSource == null){
            
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);
            
        }
       
        return dataSource;
        
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
        
    }
    
    public static void close(ResultSet rs){
        
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    public static void close(Connection conn){
        
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    
}