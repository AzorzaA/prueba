package restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionSQL {

    /*public static Connection geConnetion(){
        String conexionURL = "jdbc:sqlserver://localhost:1433;"
                +"database = RestPiuranita;"
                +"user =Sa;"
                +"password=Marciano2020@;"
                +"loginTimmeOut =30";    
        try {
            Connection conn = DriverManager.getConnection(conexionURL);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
     */
    public String usuario = "sa";
    public String pass = "Marciano2020@";
    public String url = "jdbc:sqlserver://localhost:1433;databaseName=RestPiuranita;";
    //jdbc:sqlserver://localhost:1433;databaseName=Restaurante [sa on dbo]
    public Connection cn = null;
    public Statement st = null;

    public Statement Conectar() {
        try {

            Connection cn = DriverManager.getConnection(url, usuario, pass);
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return st;
    }

}
