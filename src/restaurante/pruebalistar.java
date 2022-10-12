/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class pruebalistar {

    public static void main(String[] args) {
        Connection cn = null;
        try {
            ConexionSQL conector = new ConexionSQL();
            Statement st = conector.Conectar();
            String consult = "Select p.IdPedido, p.numMesa, e.estado_des, pl.nombrePlato"
                    + " from Pedido p "
                    + "inner join EstadoPedido e on p.IdEstado = e.IdEstado "
                    + "inner join Plato pl on pl.IdPlato = IdPlato";
            //  + "order by p.IdPedido ";
            ResultSet rs = st.executeQuery(consult);
            while (rs.next()) {
                int idpedido = rs.getInt("IdPedido");
                int nummesa = rs.getInt("numMesa");
                String Estadopedido = rs.getString("estado_des");
                String plato = rs.getString("nombrePlato");
                System.out.println(idpedido + "-" + nummesa + "\t-" + Estadopedido + "\t-" + plato);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
