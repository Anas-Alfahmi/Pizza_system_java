/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Database {

    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultset = null;

    public void Open() {
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/pizzadb", "taif", "0000");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet ListOrders() {
        try {

            String query8 = "SELECT * FROM PIZAA";
            statement = connection.createStatement();
            resultset = statement.executeQuery(query8);

        } catch (SQLException err) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, err);
        }
        return resultset;

    }

    public void New(String name, String Size,
            String topping, String Total) {
        try {

            String query9 = "insert into PIZAA(name,size,topping,total) Values ('" + name + "','" + Size + "'"
                    + ",'" + topping + "','" + Total + "')";
            statement = connection.createStatement();

            statement.executeUpdate(query9);

        } catch (SQLException err) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, err);
        }

    }
}
