/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class MostrarPlatos {

    private String idPlato;
    private String nomPlato;
    private double precio;
    private byte imagen;

    public MostrarPlatos() {
    }

    public MostrarPlatos(String idPlato, String nomPlato, double precio, byte imagen) {
        this.idPlato = idPlato;
        this.nomPlato = nomPlato;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(String idPlato) {
        this.idPlato = idPlato;
    }

    public String getNomPlato() {
        return nomPlato;
    }

    public void setNomPlato(String nomPlato) {
        this.nomPlato = nomPlato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public byte getImagen() {
        return imagen;
    }

    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }

  /*  public List<MostrarPlatos> mostrarMenu() {
        List<MostrarPlatos> item = new ArrayList<>();
        Connection con = null;

        try {
            ConexionSQL conexion = new ConexionSQL();
            Statement st = conexion.Conectar();
            String consultasql = "Select * from Platos";
            ResultSet rs = st.executeQuery(consultasql);

            while (rs.next()) {
                String idPlato = rs.getString("IdPlato");
                String nomPlato = rs.getString("desc_plato");
                double precio = rs.getDouble("precio");
                byte imagen = rs.getByte("imagen");
                item.add(new MostrarPlatos(idPlato, nomPlato, precio, imagen));
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return item;
    }

  */
}
