package restaurante;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MostrarPedidos {

    private int idpedido;
    private double precio;
    private String mesa, plato, fecha, Estadopedido;

    public MostrarPedidos() {
    }

    public MostrarPedidos(int idpedido, double precio, String mesa, String plato, String fecha, String Estadopedido) {
        this.idpedido = idpedido;
        this.precio = precio;
        this.mesa = mesa;
        this.plato = plato;
        this.fecha = fecha;
        this.Estadopedido = Estadopedido;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadopedido() {
        return Estadopedido;
    }

    public void setEstadopedido(String Estadopedido) {
        this.Estadopedido = Estadopedido;
    }

    public List<MostrarPedidos> listarPedido() {
        List<MostrarPedidos> Lista = new ArrayList<>();
        Connection cn = null;

        try {
            ConexionSQL conector = new ConexionSQL();
            Statement st = conector.Conectar();
            //cn = ConexionSQL.Statement st = cn.createStatement();
            String consult = "Select dt.idPedido, mm.desc_mesa, pl.desc_plato, pl.precio, pp.fechaInicio, ep.des_estado "
                    + " from Detalle_Pedido dt "
                    + "inner join Platos pl on pl.idPlato=dt.idPlato "
                    + "inner join pedido pp on pp.idPedido = dt.idPedido "
                    + "inner join mesa mm on mm.idmesa =pp.idmesa "
                    + "inner join EstadoPedido ep on ep.idEstado =pp.idEstado "
                    + " where ep.idEstado = '2'";

            /* String consult = "Select p.IdPedido, p.numMesa, e.estado_des, pl.nombrePlato, p.horaPedido"
                    + " from Pedido p "
                    + "inner join EstadoPedido e on p.IdEstado = e.IdEstado "
                    + "inner join Plato pl on pl.IdPlato = IdPlato "
                    //  +" where p.IdEstado ='2'";
                    + " where p.IdEstado ='2'";*/
            ResultSet rs = st.executeQuery(consult);

            while (rs.next()) {
                int idpedido = rs.getInt("IdPedido");
                String mesa = rs.getString("desc_mesa");
                String plato = rs.getString("desc_plato");
                double precio = rs.getDouble("precio");
                String Estadopedido = rs.getString("des_estado");
                String fecha = rs.getString("fechaInicio");
                Lista.add(new MostrarPedidos(idpedido, precio, mesa, plato, fecha, Estadopedido));
                //rs.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return Lista;

    }
    
    

}
