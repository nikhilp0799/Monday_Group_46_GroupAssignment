/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ProductManagement.Product;

/**
 *
 * @author nikhilpandey
 */
public class Simulation extends javax.swing.JFrame {

    private JTable tblOrderItems; // Declare the table field
    private JPanel mainPanel; // Existing field for navigation
    private int totalProfit = 0; // Keep track of the profit

    /**
     * Creates new form Simulation
     */
 public Simulation(JTable tblOrderItems, JPanel mainPanel) {
    initComponents();
    this.tblOrderItems = tblOrderItems; // Initialize the table
    this.mainPanel = mainPanel; // Initialize the panel

    // Ensure the table model reflects the latest data
    DefaultTableModel model = (DefaultTableModel) tblOrderItems.getModel();

    // Convert the table model data into a Map<Product, Integer>
    Map<Product, Integer> prod_actual_price = new HashMap<>();
    for (int row = 0; row < model.getRowCount(); row++) {
        Product product = (Product) model.getValueAt(row, 0); // Product in column 0
        Integer actualPrice = (Integer) model.getValueAt(row, 1); // Price in column 1

        if (product != null && actualPrice != null) {
            prod_actual_price.put(product, actualPrice);
        }
    }

    // Generate the report using the map
    generateReport(prod_actual_price);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProfitnoadjust = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReport = new javax.swing.JTable();
        lblSimulationReport = new javax.swing.JLabel();
        lblMaxImpact = new javax.swing.JLabel();
        txtMaxImpact = new javax.swing.JTextField();
        lblProfitafteradjust = new javax.swing.JLabel();
        txtProfitAfterAdjusting = new javax.swing.JTextField();
        lblProdnumabovetar = new javax.swing.JLabel();
        txtProdnumabovetar = new javax.swing.JTextField();
        lblProfnoadjust = new javax.swing.JLabel();
        txtProfnoadjust = new javax.swing.JTextField();
        lblTargetrevnoadjust = new javax.swing.JLabel();
        txtTargetrevnoadjust = new javax.swing.JTextField();
        lblNumprodsbelowtar = new javax.swing.JLabel();
        lblTarrevaftadjust = new javax.swing.JLabel();
        txtTarrevafteradjust = new javax.swing.JTextField();
        txtNumprodsbelowtar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProfitnoadjust.setBackground(new java.awt.Color(255, 102, 102));

        tblReport.setBackground(new java.awt.Color(204, 255, 102));
        tblReport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Original Target Price", "Adjusted Target Price", "Impact", "Result"
            }
        ));
        jScrollPane1.setViewportView(tblReport);

        lblSimulationReport.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblSimulationReport.setText("Report");

        lblMaxImpact.setText("Max Impact");

        txtMaxImpact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxImpactActionPerformed(evt);
            }
        });

        lblProfitafteradjust.setText("Profit After Adjusting");

        lblProdnumabovetar.setText("Number of Products sold above target");

        txtProdnumabovetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdnumabovetarActionPerformed(evt);
            }
        });

        lblProfnoadjust.setText("Profit no adjustment");

        txtProfnoadjust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfnoadjustActionPerformed(evt);
            }
        });

        lblTargetrevnoadjust.setText("Target revenue no adjustment");

        txtTargetrevnoadjust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTargetrevnoadjustActionPerformed(evt);
            }
        });

        lblNumprodsbelowtar.setText("Number of Products sold below target");

        lblTarrevaftadjust.setText("Target revenue after adjustment");

        txtTarrevafteradjust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTarrevafteradjustActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblProfitnoadjustLayout = new javax.swing.GroupLayout(lblProfitnoadjust);
        lblProfitnoadjust.setLayout(lblProfitnoadjustLayout);
        lblProfitnoadjustLayout.setHorizontalGroup(
            lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblProfitnoadjustLayout.createSequentialGroup()
                .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblProfitnoadjustLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblProfitnoadjustLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(lblProfitnoadjustLayout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(lblProfnoadjust))
                                .addComponent(lblProfitafteradjust, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblMaxImpact, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblProdnumabovetar))
                        .addGap(35, 35, 35)
                        .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProfitAfterAdjusting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaxImpact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProdnumabovetar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProfnoadjust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTarrevaftadjust)
                            .addComponent(lblTargetrevnoadjust)
                            .addComponent(lblNumprodsbelowtar))
                        .addGap(28, 28, 28)
                        .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTargetrevnoadjust)
                            .addComponent(txtTarrevafteradjust)
                            .addComponent(txtNumprodsbelowtar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lblProfitnoadjustLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(lblSimulationReport)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        lblProfitnoadjustLayout.setVerticalGroup(
            lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblProfitnoadjustLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(lblSimulationReport, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtProfnoadjust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblProfitnoadjustLayout.createSequentialGroup()
                        .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaxImpact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaxImpact)
                            .addComponent(lblTargetrevnoadjust)
                            .addComponent(txtTargetrevnoadjust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProfitAfterAdjusting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTarrevaftadjust)
                            .addComponent(txtTarrevafteradjust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProfitafteradjust))
                        .addGap(18, 18, 18)
                        .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProdnumabovetar)
                            .addGroup(lblProfitnoadjustLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumprodsbelowtar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNumprodsbelowtar)
                                .addComponent(txtProdnumabovetar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblProfnoadjust)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProfitnoadjust, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProfitnoadjust, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaxImpactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxImpactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxImpactActionPerformed

    private void txtProdnumabovetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdnumabovetarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdnumabovetarActionPerformed

    private void txtTarrevafteradjustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarrevafteradjustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTarrevafteradjustActionPerformed

    private void txtTargetrevnoadjustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTargetrevnoadjustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTargetrevnoadjustActionPerformed

    private void txtProfnoadjustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfnoadjustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfnoadjustActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaxImpact;
    private javax.swing.JLabel lblNumprodsbelowtar;
    private javax.swing.JLabel lblProdnumabovetar;
    private javax.swing.JLabel lblProfitafteradjust;
    private javax.swing.JPanel lblProfitnoadjust;
    private javax.swing.JLabel lblProfnoadjust;
    private javax.swing.JLabel lblSimulationReport;
    private javax.swing.JLabel lblTargetrevnoadjust;
    private javax.swing.JLabel lblTarrevaftadjust;
    private javax.swing.JTable tblReport;
    private javax.swing.JTextField txtMaxImpact;
    private javax.swing.JTextField txtNumprodsbelowtar;
    private javax.swing.JTextField txtProdnumabovetar;
    private javax.swing.JTextField txtProfitAfterAdjusting;
    private javax.swing.JTextField txtProfnoadjust;
    private javax.swing.JTextField txtTargetrevnoadjust;
    private javax.swing.JTextField txtTarrevafteradjust;
    // End of variables declaration//GEN-END:variables

    private void generateReport(Map<Product, Integer> prod_actual_price) {
    int maxI = 0, rwa = 0, rwoa = 0, fa = 0, fb = 0, pwoa = 0, totalProfit = 0;
    String maxImpact = "";

    DefaultTableModel model = (DefaultTableModel) tblReport.getModel();
    model.setRowCount(0);

    for (Map.Entry<Product, Integer> entry : prod_actual_price.entrySet()) { 
        Object[] row = new Object[5];
        row[0] = entry.getKey();
        Product p = (Product) row[0];

        if (p == null || entry.getValue() == null) continue;

        int actualPrice = entry.getValue();
        int targetPrice = p.getTargetPrice();
        int finalTargetPrice = p.getFinalTargetPrice();

        // Calculate metrics
        int impact = actualPrice - finalTargetPrice;
        totalProfit += impact;
        if (maxI < impact) {
            maxI = impact;
            maxImpact = p.getName();
        }

        // Populate row
        row[1] = targetPrice;
        row[2] = finalTargetPrice;
        row[3] = impact;
        row[4] = (actualPrice < finalTargetPrice)
                ? "Loss. Need to increase actual price."
                : "Profit. Can increase target price.";

        // Update counters
        rwa += finalTargetPrice;
        rwoa += targetPrice;
        pwoa += actualPrice - targetPrice;

        if (actualPrice > finalTargetPrice) {
            fa++;
        } else {
            fb++;
        }

        model.addRow(row);
    }

    // Update text fields
    txtProdnumabovetar.setText(String.valueOf(fa));
    txtNumprodsbelowtar.setText(String.valueOf(fb));
    txtMaxImpact.setText(maxI + " on product " + maxImpact);
    txtProfitAfterAdjusting.setText(String.valueOf(totalProfit));
    txtTarrevafteradjust.setText(String.valueOf(rwa));
    txtTargetrevnoadjust.setText(String.valueOf(rwoa));
    txtProfnoadjust.setText(String.valueOf(pwoa));
}

}
