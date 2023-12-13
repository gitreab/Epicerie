/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connex;
import java.sql.*;

/**
 *
 * @author Faly Rajaonah
 */
public class Connex {
    public Connection connectPostgres() throws Exception{
            Connection con = null;
            try{
                Class.forName("org.postgresql.Driver");
                con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/Epicerie","Boss","0000");
            }

            catch(Exception e){
                e.printStackTrace();
            }
            return con;
        }
        
        //// Test connexion Base
    
        public void testConnection() {
            try (Connection connection = connectPostgres()) {
                System.out.println(connection);
                System.out.println("Connection successful!");
            } catch (Exception e) {
                System.err.println("Connection failed: " + e.getMessage());
            }
        }
        
        public static void main(String[] args) {
            Connex test = new Connex();
            test.testConnection();
        }

}
