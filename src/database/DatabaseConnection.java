package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private final String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Bibliotheek;integratedSecurity=true;";
    private Connection con = null;

    public DatabaseConnection() {
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    //    public ResultSet executeQuery(String query) {
//        try {
//            Statement stmt = null;
//            ResultSet rs = null;
//
//            stmt = con.createStatement();
//            // Voer de query uit op de database.
//            rs = stmt.executeQuery(query);
//            return rs;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
