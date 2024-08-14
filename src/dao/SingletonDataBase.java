package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDataBase {
//    Connexion in the database etab_db
    private final static String URL="jdbc:mysql://localhost:3306/etab_db";
//    User name
    private final static String USERNAME="root";
//    Password
    private final static String PASSWORD="";
//     Déclaration in the objet connexion who coming de java.sql.Connection
    static Connection connection;

    private SingletonDataBase(){
        try  {
//            Create a new connexion in the database
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
//
            System.out.println(e.getMessage());
        }
    }
    public static Connection getInstance(){
        if(connection==null){
          new SingletonDataBase();
        }
        return connection;
    }
}
