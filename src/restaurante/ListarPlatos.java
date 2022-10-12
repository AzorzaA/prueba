package restaurante;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListarPlatos {

    private int idpedido, nummesa;
    private String Estadopedido, plato, fecha;

    public ListarPlatos() {
    }

    public ListarPlatos(int idpedido, int nummesa, String Estadopedido, String plato, String fecha) {
        this.idpedido = idpedido;
        this.nummesa = nummesa;
        this.Estadopedido = Estadopedido;
        this.plato = plato;
        this.fecha = fecha;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getNummesa() {
        return nummesa;
    }

    public void setNummesa(int nummesa) {
        this.nummesa = nummesa;
    }

    public String getEstadopedido() {
        return Estadopedido;
    }

    public void setEstadopedido(String Estadopedido) {
        this.Estadopedido = Estadopedido;
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

    public List<ListarPlatos> listarPedido() {
        List<ListarPlatos> Lista = new ArrayList<>();
        Connection cn = null;

        try {
            ConexionSQL conector = new ConexionSQL();
            Statement st = conector.Conectar();
            //cn = ConexionSQL.Statement st = cn.createStatement();
            String consult = "Select p.IdPedido, p.numMesa, e.estado_des, pl.nombrePlato"
                    + " from Pedido p "
                    + "inner join EstadoPedido e on p.IdEstado = e.IdEstado "
                    + "inner join Plato pl on pl.IdPlato = IdPlato";
                    //+ "where IdEstado = 2";
            ResultSet rs = st.executeQuery(consult);

            while (rs.next()) {
                int idpedido = rs.getInt("IdPedido");
                int nummesa = rs.getInt("numMesa");
                String Estadopedido = rs.getString("estado_des");
                String plato = rs.getString("nombrePlato");
                Lista.add(new ListarPlatos(idpedido, nummesa, Estadopedido, plato, fecha));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return Lista;
    }

}
