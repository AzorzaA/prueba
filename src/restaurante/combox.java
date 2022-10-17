/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class combox {

    public DefaultComboBoxModel mostplato() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            Connection cn = ConnSQL.getConexion();
            String sql = "Select idplato, desc_plato from platos";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modelo.addElement(rs.getString(2));

            }
            cn.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());

        }
        return modelo;
    }

    public DefaultComboBoxModel mosMesa() {
        DefaultComboBoxModel md = new DefaultComboBoxModel();
        try {
            Connection cn = ConnSQL.getConexion();
            String sql = "Select idmesa, desc_mesa from Mesa";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                md.addElement(rs.getString(2));
            }
            cn.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
        return md;
    }
}
