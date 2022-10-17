package restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnSQL {

    public static Connection getConexion() {
        String conexionURL = "jdbc:sqlserver://localhost:1433;"
                + "database = RestPiuranita;"
                + "user =Sa;"
                + "password=Marciano2020@;"
                + "loginTimmeOut =30";
        try {
            Connection conn = DriverManager.getConnection(conexionURL);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
