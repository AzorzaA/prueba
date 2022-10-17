/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restaurante.ConnSQL;
import restaurante.MostrarPedidos;

/**
 *
 * @author Admin
 */
public class CocinaValido extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cocina1
     */
    public CocinaValido() {
        initComponents();
        cargarPedido();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPlatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnPreparar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        tablaPlatos.setBackground(new java.awt.Color(204, 255, 204));
        tablaPlatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaPlatos.setForeground(new java.awt.Color(51, 51, 255));
        tablaPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdPedido", "Mesa", "Plato", "Precio", "Estado", "HoraPedido"
            }
        ));
        tablaPlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPlatos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Pedidos:");

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnPreparar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPreparar.setText("Preparar");
        btnPreparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrepararActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPreparar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPreparar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        cargarPedido();
        /*try {
            MostrarPedidos cons = new MostrarPedidos();
            List<MostrarPedidos> lista = cons.listarPedido();
            DefaultTableModel tabla;
            tabla = (DefaultTableModel) tablaPlatos.getModel();
            tabla.setRowCount(0);
            for (MostrarPedidos dto : lista) {
                Object[] rowData = {dto.getIdpedido(), dto.getMesa(), dto.getPlato(), dto.getPrecio(), dto.getEstadopedido(), dto.getFecha()};
                tabla.addRow(rowData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnPrepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrepararActionPerformed
        
    }//GEN-LAST:event_btnPrepararActionPerformed

    private void tablaPlatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlatosMouseClicked

    }//GEN-LAST:event_tablaPlatosMouseClicked

    private void cargarPedido() {
        DefaultTableModel pedidotabla = (DefaultTableModel) tablaPlatos.getModel();
        pedidotabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet sr;
        ResultSetMetaData rsm = null;
        int columnas;

        try {
            Connection cn = ConnSQL.getConexion();
            ps = cn.prepareStatement("Select dt.idPedido, mm.desc_mesa, pl.desc_plato, pl.precio, pp.fechaInicio, ep.des_estado "
                    + " from Detalle_Pedido dt "
                    + "inner join Platos pl on pl.idPlato=dt.idPlato "
                    + "inner join pedido pp on pp.idPedido = dt.idPedido "
                    + "inner join mesa mm on mm.idmesa =pp.idmesa "
                    + "inner join EstadoPedido ep on ep.idEstado =pp.idEstado "
                    + " where ep.idEstado = '2'");
            sr = ps.executeQuery();
            rsm = sr.getMetaData();
            columnas = rsm.getColumnCount();

            while (sr.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = sr.getObject(indice + 1);
                }
                pedidotabla.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnPreparar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaPlatos;
    // End of variables declaration//GEN-END:variables
}
