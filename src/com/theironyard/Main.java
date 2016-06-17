package com.theironyard;

import org.h2.tools.Server;
import spark.Spark;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS users (id IDENTITY, username VARCHAR)");
        stmt.execute("CREATE TABLE IF NOT EXISTS pizzas (id IDENTITY, size VARCHAR, crust VARCHAR, sauce VARCHAR)");
        stmt.execute("CREATE TABLE IF NOT EXISTS toppings (id IDENTITY, topping VARCHAR, pizza_id INT)");
    }

    public static void insertUser(Connection conn, User user) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO users VALUES (NULL, ?)");
        stmt.setString(1, user.username);
        stmt.execute();
    }

    public static ArrayList<User> selectUsers(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
        ResultSet results = stmt.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while (results.next()) {
            Integer id = results.getInt("id");
            String username = results.getString("username");
            User user = new User(id, username);
            users.add(user);
        }
        return users;
    }

    public static int insertPizza(Connection conn, Pizza pizza) throws SQLException {
        // return int whenever Zach sends code
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO pizzas VALUES (NULL, ?, ?, ?, ?)");
        stmt.setString(1, pizza.size);
        stmt.setString(2, pizza.crust);
        stmt.setString(3, pizza.sauce);
        stmt.setInt(4, pizza.userId);
        stmt.execute();
    }

    public static void insertToppings(Connection conn, ArrayList<Toppings> topping, int pizza_id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO pizzas VALUES (pizza_id, ?, ?)");

    }


    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start();
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        createTables(conn);

        Spark.externalStaticFileLocation("public");
        Spark.init();
    }
}
