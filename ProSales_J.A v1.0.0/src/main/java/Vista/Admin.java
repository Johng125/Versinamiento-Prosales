package Vista;

import Modelo.Funciones;
import static Vista.Menu.btnVolver;

public class Admin extends javax.swing.JPanel {
    Funciones funcion = new Funciones();
    public Admin() {
        initComponents();
        btnVolver.setVisible(false);
        
    }
    
    public void productos(){
        funcion.actualizarPanel(new AdminProducto());
    }
    
    public void clientes(){
        funcion.actualizarPanel(new AdminClient());
    }
    
    public void credenciales(){
        funcion.actualizarPanel(new AdminCredencial());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCliente = new javax.swing.JButton();
        btnCredencial = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(13, 13, 13));

        btnCliente.setBackground(new java.awt.Color(40, 40, 40));
        btnCliente.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(228, 228, 228));
        btnCliente.setText("Administrar Clientes");
        btnCliente.setToolTipText("");
        btnCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.setFocusable(false);
        btnCliente.setIconTextGap(0);
        btnCliente.setMargin(new java.awt.Insets(0, 14, 3, 14));
        btnCliente.setPreferredSize(new java.awt.Dimension(248, 16));
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnCredencial.setBackground(new java.awt.Color(40, 40, 40));
        btnCredencial.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnCredencial.setForeground(new java.awt.Color(228, 228, 228));
        btnCredencial.setText("Administrar Credenciales");
        btnCredencial.setToolTipText("");
        btnCredencial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        btnCredencial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCredencial.setFocusable(false);
        btnCredencial.setIconTextGap(0);
        btnCredencial.setMargin(new java.awt.Insets(0, 14, 3, 14));
        btnCredencial.setPreferredSize(new java.awt.Dimension(248, 16));
        btnCredencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredencialActionPerformed(evt);
            }
        });

        btnProducto.setBackground(new java.awt.Color(40, 40, 40));
        btnProducto.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnProducto.setForeground(new java.awt.Color(228, 228, 228));
        btnProducto.setText("Administrar Productos");
        btnProducto.setToolTipText("");
        btnProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
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
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(116, 116, 116)
                        .addComponent(btnCredencial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(188, 188, 188)))
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCredencial, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addGap(57, 57, 57))
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

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        clientes();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnCredencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCredencialActionPerformed
        credenciales();
    }//GEN-LAST:event_btnCredencialActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        productos();
    }//GEN-LAST:event_btnProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCredencial;
    private javax.swing.JButton btnProducto;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
