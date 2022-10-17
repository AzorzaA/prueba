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
            String consult = "Select dt.idPedido, mm.desc_mesa, pl.desc_plato, pl.precio, pp.fechaInicio, ep.des_estado "
                    + " from Detalle_Pedido dt "
                    + "inner join Platos pl on pl.idPlato=dt.idPlato "
                    + "inner join pedido pp on pp.idPedido = dt.idPedido "
                    + "inner join mesa mm on mm.idmesa =pp.idmesa "
                    + "inner join EstadoPedido ep on ep.idEstado =pp.idEstado "
                    + " where ep.idEstado = '2'";
            //  + "order by p.IdPedido ";
            ResultSet rs = st.executeQuery(consult);
            while (rs.next()) {
                int idpedido = rs.getInt("IdPedido");
                String nummesa = rs.getString("desc_mesa");
                String Estadopedido = rs.getString("des_estado");
                String plato = rs.getString("desc_plato");
                Double prec = rs.getDouble("precio");
                String fech = rs.getString("fechaInicio");
                System.out.println(idpedido + "-" + nummesa  + "\t-" + plato+ "\t-"+prec + "\t\t-" + Estadopedido+ "\t"+fech);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
