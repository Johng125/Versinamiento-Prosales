package Vista;

import Modelo.Funciones;
import static Vista.Menu.btnVolver;

public class Cajero extends javax.swing.JPanel {
    Funciones funcion= new Funciones();
    
    public Cajero() {
        initComponents();
        btnVolver.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnFactura = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(13, 13, 13));

        btnFactura.setBackground(new java.awt.Color(20, 20, 20));
        btnFactura.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnFactura.setForeground(new java.awt.Color(228, 228, 228));
        btnFactura.setText("Crear Factura");
        btnFactura.setToolTipText("");
        btnFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        btnFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFactura.setFocusable(false);
        btnFactura.setIconTextGap(0);
        btnFactura.setMargin(new java.awt.Insets(0, 14, 3, 14));
        btnFactura.setPreferredSize(new java.awt.Dimension(248, 16));
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        btnProducto.setBackground(new java.awt.Color(20, 20, 20));
        btnProducto.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnProducto.setForeground(new java.awt.Color(228, 228, 228));
        btnProducto.setText("Buscar Productos");
        btnProducto.setToolTipText("");
        btnProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 2, true));
        btnProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProducto.setFocusable(false);
        btnProducto.setIconTextGap(0);
        btnProducto.setMargin(new java.awt.Insets(0, 14, 3, 14));
        btnProducto.setPreferredSize(new java.awt.Dimension(248, 16));
        btnProducto.setSelected(true);
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(122, 122, 122)
                .addComponent(btnFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(199, 199, 199))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
       funcion.actualizarPanel(new CajeroVenta());
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        funcion.actualizarPanel(new Productos());
    }//GEN-LAST:event_btnProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnProducto;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
