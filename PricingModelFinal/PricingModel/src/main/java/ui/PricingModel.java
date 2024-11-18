/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Business.Business;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.OrderItem;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;

/**
 *
 * @author nikhilpandey
 */
public class PricingModel extends javax.swing.JFrame {
    private SupplierDirectory suppliers = new SupplierDirectory();
    private Map<String, ProductCatalog> supplierCatalogs; 
    private Map<Product, Integer> prod_actual_price = new HashMap<>();
    private Map<String, CustomerDirectory> supplierCustomers;
    private Business business;

    /**
     * Creates new form PricingModel
     */
public PricingModel() {
    supplierCatalogs = new HashMap<>();
    supplierCustomers = new HashMap<>();  // Initialize the customer directory map
    business = new Business("Business");


    initComponents();

    // Create demo data to populate the Supplier and ProductCatalogs
    createDemoData(); 

    // Populate the supplier dropdown after creating demo data
    populateSupplierDropdown(); 
}

private void createDemoData() {
    // Create business and suppliers
    Supplier supplier1 = business.getSupplierDirectory().newSupplier("Apple");
    Supplier supplier2 = business.getSupplierDirectory().newSupplier("Microsoft");
    Supplier supplier3 = business.getSupplierDirectory().newSupplier("Dell");
    Supplier supplier4 = business.getSupplierDirectory().newSupplier("Samsung");
    Supplier supplier5 = business.getSupplierDirectory().newSupplier("Sony");

    // Create ProductCatalogs and CustomerDirectories for each supplier
    ProductCatalog appleCatalog = supplier1.getProductCatalog();
    ProductCatalog microsoftCatalog = supplier2.getProductCatalog();
    ProductCatalog dellCatalog = supplier3.getProductCatalog();
    ProductCatalog samsungCatalog = supplier4.getProductCatalog();
    ProductCatalog sonyCatalog = supplier5.getProductCatalog();

    supplierCatalogs.put("Apple", appleCatalog);
    supplierCatalogs.put("Microsoft", microsoftCatalog);
    supplierCatalogs.put("Dell", dellCatalog);
    supplierCatalogs.put("Samsung", samsungCatalog);
    supplierCatalogs.put("Sony", sonyCatalog);

    appleCatalog.newProduct("iPhone 15 Pro", 850, 1200, 1000);
    appleCatalog.newProduct("MacBook Air M2", 900, 1300, 1100);
    appleCatalog.newProduct("iPad mini", 550, 800, 700);
    appleCatalog.newProduct("Apple Watch", 400, 700, 500);
    appleCatalog.newProduct("Apple TV", 2500, 4000, 3000);
    appleCatalog.newProduct("MacBook Air M3", 1000, 1300, 1100);
    appleCatalog.newProduct("iPhone 16 Pro", 950, 1200, 1000);
    appleCatalog.newProduct("MacBook Air M1", 700, 1300, 1100);
    
    dellCatalog.newProduct("Dell XPS 13", 850, 1200, 1000);
    dellCatalog.newProduct("Dell Inspiron 15", 900, 1300, 1100);
    dellCatalog.newProduct("Dell Venue 8 Tablet", 550, 800, 700);
    dellCatalog.newProduct("Dell Smartwatch", 400, 700, 500);
    dellCatalog.newProduct("Dell UltraSharp Monitor", 2500, 4000, 3000);
    dellCatalog.newProduct("Dell XPS 15", 1000, 1300, 1100);
    dellCatalog.newProduct("Dell G7 15 Gaming Laptop", 950, 1200, 1000);
    dellCatalog.newProduct("Dell Latitude 14", 700, 1300, 1100);

    sonyCatalog.newProduct("Sony Xperia 1 IV", 850, 1200, 1000);
    sonyCatalog.newProduct("Sony VAIO Laptop", 900, 1300, 1100);
    sonyCatalog.newProduct("Sony Tablet S", 550, 800, 700);
    sonyCatalog.newProduct("Sony Smartwatch", 400, 700, 500);
    sonyCatalog.newProduct("Sony Bravia TV", 2500, 4000, 3000);
    sonyCatalog.newProduct("Sony VAIO Laptop Pro", 1000, 1300, 1100);
    sonyCatalog.newProduct("Sony Xperia 5 II", 950, 1200, 1000);
    sonyCatalog.newProduct("Sony VAIO Laptop Air", 700, 1300, 1100);
    
    samsungCatalog.newProduct("Samsung Galaxy S23", 850, 1200, 1000);
    samsungCatalog.newProduct("Samsung Galaxy Book Pro", 900, 1300, 1100);
    samsungCatalog.newProduct("Samsung Galaxy Tab S8", 550, 800, 700);
    samsungCatalog.newProduct("Samsung Galaxy Watch 6", 400, 700, 500);
    samsungCatalog.newProduct("Samsung QLED TV", 2500, 4000, 3000);
    samsungCatalog.newProduct("Samsung Galaxy Book 3", 1000, 1300, 1100);
    samsungCatalog.newProduct("Samsung Galaxy Z Fold 5", 950, 1200, 1000);
    samsungCatalog.newProduct("Samsung Galaxy Book 2", 700, 1300, 1100);

    microsoftCatalog.newProduct("Microsoft Surface Laptop 4", 850, 1200, 1000);
    microsoftCatalog.newProduct("Microsoft Surface Book 3", 900, 1300, 1100);
    microsoftCatalog.newProduct("Microsoft Surface Go 3", 550, 800, 700);
    microsoftCatalog.newProduct("Microsoft Band", 400, 700, 500);
    microsoftCatalog.newProduct("Microsoft Surface Hub 2S", 2500, 4000, 3000);
    microsoftCatalog.newProduct("Microsoft Surface Pro 7", 1000, 1300, 1100);
    microsoftCatalog.newProduct("Microsoft Surface Duo 2", 950, 1200, 1000);
    microsoftCatalog.newProduct("Microsoft Surface Laptop Go", 700, 1300, 1100);


    // Create customers per supplier and populate customer directories
    CustomerDirectory appleCustomers = new CustomerDirectory(business);
    for (int i = 1; i <= 10; i++) {
        Person p = new Person("AppleCustomer" + i);
        appleCustomers.newCustomerProfile(p);
    }
    supplierCustomers.put("Apple", appleCustomers);


    CustomerDirectory microsoftCustomers = new CustomerDirectory(business);
    for (int i = 1; i <= 10; i++) {
        Person p = new Person("MicrosoftCustomer" + i);
        microsoftCustomers.newCustomerProfile(p);
    }
    supplierCustomers.put("Microsoft", microsoftCustomers);


    CustomerDirectory sonyCustomers = new CustomerDirectory(business);
    for (int i = 1; i <= 10; i++) {
        Person p = new Person("SonyCustomer" + i);
        sonyCustomers.newCustomerProfile(p);
    }
    supplierCustomers.put("Sony", sonyCustomers);

   // Repeat similarly for other suppliers
    CustomerDirectory samsungCustomers = new CustomerDirectory(business);
    for (int i = 1; i <= 10; i++) {
        Person p = new Person("SamsungCustomer" + i);
        samsungCustomers.newCustomerProfile(p);
    }
    supplierCustomers.put("Samsung", samsungCustomers);
    
   // Repeat similarly for other suppliers
    CustomerDirectory dellCustomers = new CustomerDirectory(business);
    for (int i = 1; i <= 10; i++) {
        Person p = new Person("DellCustomer" + i);
        dellCustomers.newCustomerProfile(p);
    }
    supplierCustomers.put("Dell", dellCustomers);
    
//private void initializeSupplierData() {
//    supplierCatalogs = new HashMap<>();
//
//    // Create ProductCatalog for each supplier and add Products
//    ProductCatalog supplier1Catalog = new ProductCatalog();
//    supplier1Catalog.newProduct("Product A", 10, 25, 15); // Use correct method
//    supplier1Catalog.newProduct("Product B", 20, 35, 25);
//    supplierCatalogs.put("Supplier 1", supplier1Catalog);
//
//    ProductCatalog supplier2Catalog = new ProductCatalog();
//    supplier2Catalog.newProduct("Product C", 5, 20, 10);
//    supplierCatalogs.put("Supplier 2", supplier2Catalog);
//    
//    ProductCatalog supplier3Catalog = new ProductCatalog();
//    supplier3Catalog.newProduct("Product D", 15, 30, 20);
//    supplierCatalogs.put("Supplier 3", supplier3Catalog);
//    
//    ProductCatalog supplier4Catalog = new ProductCatalog();
//    supplier4Catalog.newProduct("Product E", 12, 28, 18);
//    supplierCatalogs.put("Supplier 4", supplier4Catalog);
//    
//    ProductCatalog sonyCatalog = new ProductCatalog();
//    sonyCatalog.newProduct("Product F", 10, 25, 15);
//    supplierCatalogs.put("Sony", sonyCatalog);
//
//    // Populate the dropdown (assuming you want to show suppliers)
//    populateSupplierDropdown();
//}
}
    private void populateSupplierDropdown() {
    if (dropdownSupplier != null) {
        dropdownSupplier.removeAllItems(); // Clear existing items
        for (String supplier : supplierCatalogs.keySet()) {
            dropdownSupplier.addItem(supplier);
        }
        
        // Debug statement to log available suppliers
        System.out.println("Suppliers available: " + supplierCatalogs.keySet());
    } else {
        System.err.println("dropdownSupplier is not initialized.");
    }
}
    
private void populateProductTable(ProductCatalog products) {
    DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
    model.setRowCount(0);
    
    for (Product p : products.getProductList()) {
        Object[] row = new Object[4];
        row[0] = p; // Product name or identifier
        row[1] = p.getFloorPrice();
        row[2] = p.getCeilingPrice();
        row[3] = p.getTargetPrice();
        model.addRow(row);
    }
}


private void autoAdjustPricesAndQuantities(int adjustmentLevel) {
    // Adjustment levels
    int priceDecreasePercentage;
    int quantityIncreasePercentage;
    int priceIncreasePercentage;
    int targetAdjustmentPercentage; // New percentage for the "Target" adjustment

    // Set adjustment percentages based on adjustment level
    switch (adjustmentLevel) {
        case 1: // Low adjustments
            priceDecreasePercentage = 5;
            quantityIncreasePercentage = 10;
            priceIncreasePercentage = 5;
            targetAdjustmentPercentage = 5; // Adjust target by 5%
            break;
        case 2: // Moderate adjustments
            priceDecreasePercentage = 10;
            quantityIncreasePercentage = 15;
            priceIncreasePercentage = 10;
            targetAdjustmentPercentage = 10; // Adjust target by 10%
            break;
        case 3: // High adjustments
            priceDecreasePercentage = 15;
            quantityIncreasePercentage = 20;
            priceIncreasePercentage = 15;
            targetAdjustmentPercentage = 15; // Adjust target by 15%
            break;
        default:
            JOptionPane.showMessageDialog(this, "Invalid adjustment level!");
            return;
    }

    DefaultTableModel model = (DefaultTableModel) tblOrderItems.getModel();
    for (int row = 0; row < model.getRowCount(); row++) {
        // Get the order item
        Product product = (Product) model.getValueAt(row, 0);
        int currentPrice = prod_actual_price.get(product);
        int quantity = (int) model.getValueAt(row, 2);
        int target = (int) model.getValueAt(row, 5); // Assume "Target" is in column 5

        // Apply adjustments
        double newPrice = currentPrice * (1 - priceDecreasePercentage / 100.0); // Decrease price
        newPrice *= (1 + priceIncreasePercentage / 100.0); // Increase price
        int newQuantity = (int) (quantity * (1 + quantityIncreasePercentage / 100.0)); // Adjust quantity
        int newTarget = (int) (target * (1 + targetAdjustmentPercentage / 100.0)); // Adjust target

        // Update table
        model.setValueAt((int) newPrice, row, 1); // Update price
        model.setValueAt(newQuantity, row, 2); // Update quantity
        model.setValueAt((int) newPrice * newQuantity, row, 3); // Update total
        model.setValueAt(newTarget, row, 5); // Update target
    }

    JOptionPane.showMessageDialog(this, "Adjustments applied automatically!");
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        dropdownSupplier = new javax.swing.JComboBox<>();
        lblSupplier = new javax.swing.JLabel();
        lblProduct = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderItems = new javax.swing.JTable();
        lblOrderItem = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        txtCustomer = new javax.swing.JLabel();
        btnAdjust = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnGenerateReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(204, 153, 255));

        dropdownSupplier.setBackground(new java.awt.Color(204, 204, 255));
        dropdownSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Supplier1", "Supplier2", "Supplier3", "Supplier4" }));
        dropdownSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdownSupplierActionPerformed(evt);
            }
        });

        lblSupplier.setBackground(new java.awt.Color(0, 204, 204));
        lblSupplier.setText("  Supplier");

        lblProduct.setText("Product");

        tblProduct.setAutoCreateRowSorter(true);
        tblProduct.setBackground(new java.awt.Color(102, 204, 255));
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Floor", "Ceiling", "Target"
            }
        ));
        jScrollPane1.setViewportView(tblProduct);

        tblOrderItems.setBackground(new java.awt.Color(255, 153, 153));
        tblOrderItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Actual Price", "Quantity", "ItemTotal", "PricePerformance", "Target"
            }
        ));
        tblOrderItems.setEnabled(false);
        jScrollPane2.setViewportView(tblOrderItems);

        lblOrderItem.setBackground(new java.awt.Color(0, 204, 204));
        lblOrderItem.setText("Order Items");

        btnAdd.setBackground(new java.awt.Color(204, 204, 255));
        btnAdd.setText("Add");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblCustomers.setBackground(new java.awt.Color(153, 153, 255));
        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer"
            }
        ));
        jScrollPane3.setViewportView(tblCustomers);

        txtCustomer.setBackground(new java.awt.Color(0, 204, 204));
        txtCustomer.setText("Customer");

        btnAdjust.setText("Adjust");
        btnAdjust.setEnabled(false);
        btnAdjust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjustActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnGenerateReport.setText("Generate Report");
        btnGenerateReport.setEnabled(false);
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(btnAdjust)
                        .addGap(27, 27, 27)
                        .addComponent(btnSave)
                        .addGap(227, 227, 227)
                        .addComponent(btnGenerateReport))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrderItem)))
                    .addComponent(btnAdd)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dropdownSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 59, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dropdownSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(lblOrderItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdjust)
                    .addComponent(btnSave)
                    .addComponent(btnGenerateReport))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        // TODO add your handling code here:

    Simulation r = new Simulation(tblOrderItems, this.mainPanel); // Pass JTable directly
    r.setVisible(true);
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        // Save adjustments to the data model
        TableModel model = tblOrderItems.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            Product product = (Product) model.getValueAt(row, 0);
            product.setFinalTargetPrice((int) model.getValueAt(row, 5));
        }
        JOptionPane.showMessageDialog(this, "Adjustments saved!");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAdjustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjustActionPerformed
        // TODO add your handling code here:
        // Enable Save Button
        btnSave.setEnabled(true);
        tblOrderItems.setEnabled(true);

        // Ask the user for adjustment level
        String[] options = {"1 - Low", "2 - Moderate", "3 - High"};
        String selectedOption = (String) JOptionPane.showInputDialog(
            this,
            "Select Adjustment Level:",
            "Adjustment Levels",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );

        if (selectedOption != null) {
            int adjustmentLevel = Integer.parseInt(selectedOption.split(" - ")[0]);
            autoAdjustPricesAndQuantities(adjustmentLevel);
        }
    }//GEN-LAST:event_btnAdjustActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        btnGenerateReport.setEnabled(true);
        int selectedRowIndex = tblProduct.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product first.");
            return;
        }

        Product product = (Product) tblProduct.getValueAt(selectedRowIndex, 0);
        Random random = new Random();
        OrderItem orderItem = new OrderItem(product, random.nextInt(100) + 1, 10);

        DefaultTableModel model = (DefaultTableModel) tblOrderItems.getModel();
        Object[] row = new Object[6];
        row[0] = product;
        row[1] = orderItem.getActualPrice();
        row[2] = orderItem.getQuantity();
        row[3] = orderItem.getOrderItemTotal();
        row[4] = orderItem.calculatePricePerformance();
        row[5] = product.getTargetPrice();
        prod_actual_price.put(product, orderItem.getActualPrice());
        model.addRow(row);

        // Enable adjust button after adding an item
        btnAdjust.setEnabled(true);

        // Automatically apply the default adjustment after adding an item
        autoAdjustPricesAndQuantities(1); // Default adjustment level set to Low

    }//GEN-LAST:event_btnAddActionPerformed

    private void dropdownSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdownSupplierActionPerformed
        // TODO add your handling code here:
        // Get the selected item from the combo box
        
        btnAdd.setEnabled(true);
        Object selectedItem = dropdownSupplier.getSelectedItem();

        if (selectedItem != null) {
            String selectedSupplierName = selectedItem.toString();

            // Get the product catalog for the selected supplier
            ProductCatalog productCatalog = supplierCatalogs.get(selectedSupplierName);
            // Get the customer directory for the selected supplier
            CustomerDirectory customerDirectory = supplierCustomers.get(selectedSupplierName);

            if (productCatalog != null) {
                // Populate product table with the products
                populateProductTable(productCatalog);
            }

            if (customerDirectory != null) {
                // Populate customer table with the customers
                populateCustomerTable(customerDirectory);
            } else {
                System.out.println("No customer directory found for the selected supplier.");
            }
        } else {
            System.out.println("No supplier selected.");
        }

        //    private void autoAdjustPricesAndQuantities(int adjustmentLevel) {
            //         Adjustment logic remains unchanged
            //                Business b = new Business("Business");
            //                btnAdd.setEnabled(true);
            //        selectedSupplier = dropdownSupplier.getSelectedItem().toString();
            //        if (selectedSupplier == "Supplier 1"){
                //            Apple = new ProductCatalog();
                //            Product s1p1 = Apple.newProduct("s1p1",10, 25, 15);  // fp = 10, tp = 15, cp = 25
                //            Product s1p2 = Apple.newProduct("s1p2",20, 35, 25);  // fp = 20, tp = 25, cp = 35
                //            Product s1p3 = Apple.newProduct("s1p3",30, 45, 35);  // fp = 30, tp = 35, cp = 45
                //            Product s1p4 = Apple.newProduct("s1p4",40, 55, 45);  // fp = 40, tp = 45, cp = 55
                //            Product s1p5 = Apple.newProduct("s1p5",50, 65, 55);  // fp = 50, tp = 55, cp = 65
                //            Product s1p6 = Apple.newProduct("s1p6",60, 75, 65);  // fp = 60, tp = 65, cp = 75
                //            Product s1p7 = Apple.newProduct("s1p7",70, 85, 75);  // fp = 70, tp = 75, cp = 85
                //            Product s1p8 = Apple.newProduct("s1p8",80, 95, 85);  // fp = 80, tp = 85, cp = 95
                //            Product s1p9 = Apple.newProduct("s1p9",90, 105, 95); // fp = 90, tp = 95, cp = 105
                //            Product s1p10 = Apple.newProduct("s1p10",100, 115, 105); // fp = 100, tp = 105, cp = 115
                //
                //            txtSalesPerson.setText("Sales person 1");
                //
                //            PersonDirectory pd = new PersonDirectory();
                //            Person p1=pd.newPerson("s1c1");
                //            Person p2=pd.newPerson("s1c2");
                //            Person p3=pd.newPerson("s1c3");
                //            Person p4=pd.newPerson("s1c4");
                //            Person p5=pd.newPerson("s1c5");
                //            Person p6=pd.newPerson("s1c6");
                //            Person p7=pd.newPerson("s1c7");
                //            Person p8=pd.newPerson("s1c8");
                //            Person p9=pd.newPerson("s1c9");
                //            Person p10=pd.newPerson("s1c10");
                //
                //            CustomerDirectory cs1 = new CustomerDirectory(b);
                //            cs1.newCustomerProfile(p1);
                //            cs1.newCustomerProfile(p2);
                //            cs1.newCustomerProfile(p3);
                //            cs1.newCustomerProfile(p4);
                //            cs1.newCustomerProfile(p5);
                //            cs1.newCustomerProfile(p6);
                //            cs1.newCustomerProfile(p7);
                //            cs1.newCustomerProfile(p8);
                //            cs1.newCustomerProfile(p9);
                //            cs1.newCustomerProfile(p10);
                //            populateCustomerTable(cs1);
                //
                //            populateProductTable(Apple);
                //        }
            //        else if (selectedSupplier == "Supplier 2"){
                //            Microsoft = new ProductCatalog();
                //            Product s2p1 = Microsoft.newProduct("s2p1", 5, 20, 10);    // fp = 5, cp = 20, tp = 10
                //            Product s2p2 = Microsoft.newProduct("s2p2", 15, 30, 20);   // fp = 15, cp = 30, tp = 20
                //            Product s2p3 = Microsoft.newProduct("s2p3", 25, 40, 30);   // fp = 25, cp = 40, tp = 30
                //            Product s2p4 = Microsoft.newProduct("s2p4", 35, 50, 40);   // fp = 35, cp = 50, tp = 40
                //            Product s2p5 = Microsoft.newProduct("s2p5", 45, 60, 50);   // fp = 45, cp = 60, tp = 50
                //            Product s2p6 = Microsoft.newProduct("s2p6", 55, 70, 60);   // fp = 55, cp = 70, tp = 60
                //            Product s2p7 = Microsoft.newProduct("s2p7", 65, 80, 70);   // fp = 65, cp = 80, tp = 70
                //            Product s2p8 = Microsoft.newProduct("s2p8", 75, 90, 80);   // fp = 75, cp = 90, tp = 80
                //            Product s2p9 = Microsoft.newProduct("s2p9", 85, 100, 90);  // fp = 85, cp = 100, tp = 90
                //            Product s2p10 = Microsoft.newProduct("s2p10", 95, 110, 100); // fp = 95, cp = 110, tp = 100
                //            populateProductTable(Microsoft);
                //
                //            txtSalesPerson.setText("Sales person 2");
                //
                //            PersonDirectory pd = new PersonDirectory();
                //            Person p1=pd.newPerson("s2c1");
                //            Person p2=pd.newPerson("s2c2");
                //            Person p3=pd.newPerson("s2c3");
                //            Person p4=pd.newPerson("s2c4");
                //            Person p5=pd.newPerson("s2c5");
                //            Person p6=pd.newPerson("s2c6");
                //            Person p7=pd.newPerson("s2c7");
                //            Person p8=pd.newPerson("s2c8");
                //            Person p9=pd.newPerson("s2c9");
                //            Person p10=pd.newPerson("s2c10");
                //
                //            CustomerDirectory cs2 = new CustomerDirectory(b);
                //            cs2.newCustomerProfile(p1);
                //            cs2.newCustomerProfile(p2);
                //            cs2.newCustomerProfile(p3);
                //            cs2.newCustomerProfile(p4);
                //            cs2.newCustomerProfile(p5);
                //            cs2.newCustomerProfile(p6);
                //            cs2.newCustomerProfile(p7);
                //            cs2.newCustomerProfile(p8);
                //            cs2.newCustomerProfile(p9);
                //            cs2.newCustomerProfile(p10);
                //            populateCustomerTable(cs2);
                //        }
            //        else if (selectedSupplier == "Supplier 3"){
                //            Dell = new ProductCatalog();
                //            Product s3p1 = Dell.newProduct("s3p1", 8, 22, 14);     // fp = 8, tp = 14, cp = 22
                //            Product s3p2 = Dell.newProduct("s3p2", 18, 32, 24);    // fp = 18, tp = 24, cp = 32
                //            Product s3p3 = Dell.newProduct("s3p3", 28, 42, 34);    // fp = 28, tp = 34, cp = 42
                //            Product s3p4 = Dell.newProduct("s3p4", 38, 52, 44);    // fp = 38, tp = 44, cp = 52
                //            Product s3p5 = Dell.newProduct("s3p5", 48, 62, 54);    // fp = 48, tp = 54, cp = 62
                //            Product s3p6 = Dell.newProduct("s3p6", 58, 72, 64);    // fp = 58, tp = 64, cp = 72
                //            Product s3p7 = Dell.newProduct("s3p7", 68, 82, 74);    // fp = 68, tp = 74, cp = 82
                //            Product s3p8 = Dell.newProduct("s3p8", 78, 92, 84);    // fp = 78, tp = 84, cp = 92
                //            Product s3p9 = Dell.newProduct("s3p9", 88, 102, 94);   // fp = 88, tp = 94, cp = 102
                //            Product s3p10 = Dell.newProduct("s3p10", 98, 112, 104); // fp = 98, tp = 104, cp = 112
                //            populateProductTable(Dell);
                //
                //            txtSalesPerson.setText("Sales person 3");
                //
                //            PersonDirectory pd = new PersonDirectory();
                //            Person p1=pd.newPerson("s3c1");
                //            Person p2=pd.newPerson("s3c2");
                //            Person p3=pd.newPerson("s3c3");
                //            Person p4=pd.newPerson("s3c4");
                //            Person p5=pd.newPerson("s3c5");
                //            Person p6=pd.newPerson("s3c6");
                //            Person p7=pd.newPerson("s3c7");
                //            Person p8=pd.newPerson("s3c8");
                //            Person p9=pd.newPerson("s3c9");
                //            Person p10=pd.newPerson("s3c10");
                //
                //            CustomerDirectory cs3 = new CustomerDirectory(b);
                //            cs3.newCustomerProfile(p1);
                //            cs3.newCustomerProfile(p2);
                //            cs3.newCustomerProfile(p3);
                //            cs3.newCustomerProfile(p4);
                //            cs3.newCustomerProfile(p5);
                //            cs3.newCustomerProfile(p6);
                //            cs3.newCustomerProfile(p7);
                //            cs3.newCustomerProfile(p8);
                //            cs3.newCustomerProfile(p9);
                //            cs3.newCustomerProfile(p10);
                //            populateCustomerTable(cs3);
                //
                //        }
            //        else if (selectedSupplier == "Supplier 4"){
                //            Samsung = new ProductCatalog();
                //            Product s4p1 = Samsung.newProduct("s4p1", 12, 28, 18);     // fp = 12, tp = 18, cp = 28
                //            Product s4p2 = Samsung.newProduct("s4p2", 22, 38, 28);     // fp = 22, tp = 28, cp = 38
                //            Product s4p3 = Samsung.newProduct("s4p3", 32, 48, 38);     // fp = 32, tp = 38, cp = 48
                //            Product s4p4 = Samsung.newProduct("s4p4", 42, 58, 48);     // fp = 42, tp = 48, cp = 58
                //            Product s4p5 = Samsung.newProduct("s4p5", 52, 68, 58);     // fp = 52, tp = 58, cp = 68
                //            Product s4p6 = Samsung.newProduct("s4p6", 62, 78, 68);     // fp = 62, tp = 68, cp = 78
                //            Product s4p7 = Samsung.newProduct("s4p7", 72, 88, 78);     // fp = 72, tp = 78, cp = 88
                //            Product s4p8 = Samsung.newProduct("s4p8", 82, 98, 88);     // fp = 82, tp = 88, cp = 98
                //            Product s4p9 = Samsung.newProduct("s4p9", 92, 108, 98);    // fp = 92, tp = 98, cp = 108
                //            Product s4p10 = Samsung.newProduct("s4p10", 102, 118, 108); // fp = 102, tp = 108, cp = 118
                //            populateProductTable(Samsung);
                //
                //            txtSalesPerson.setText("Sales person 4");
                //
                //            PersonDirectory pd = new PersonDirectory();
                //            Person p1=pd.newPerson("s4c1");
                //            Person p2=pd.newPerson("s4c2");
                //            Person p3=pd.newPerson("s4c3");
                //            Person p4=pd.newPerson("s4c4");
                //            Person p5=pd.newPerson("s4c5");
                //            Person p6=pd.newPerson("s4c6");
                //            Person p7=pd.newPerson("s4c7");
                //            Person p8=pd.newPerson("s4c8");
                //            Person p9=pd.newPerson("s4c9");
                //            Person p10=pd.newPerson("s4c10");
                //
                //            CustomerDirectory cs4 = new CustomerDirectory(b);
                //            cs4.newCustomerProfile(p1);
                //            cs4.newCustomerProfile(p2);
                //            cs4.newCustomerProfile(p3);
                //            cs4.newCustomerProfile(p4);
                //            cs4.newCustomerProfile(p5);
                //            cs4.newCustomerProfile(p6);
                //            cs4.newCustomerProfile(p7);
                //            cs4.newCustomerProfile(p8);
                //            cs4.newCustomerProfile(p9);
                //            cs4.newCustomerProfile(p10);
                //            populateCustomerTable(cs4);
                //
                //        }
            //        else{
                //            Sony = new ProductCatalog();
                //            Product s5p1 = Sony.newProduct("s5p1",10, 25, 15);  // fp = 10, tp = 15, cp = 25
                //            Product s5p2 = Sony.newProduct("s5p2",20, 35, 25);  // fp = 20, tp = 25, cp = 35
                //            Product s5p3 = Sony.newProduct("s5p3",30, 45, 35);  // fp = 30, tp = 35, cp = 45
                //            Product s5p4 = Sony.newProduct("s5p4",40, 55, 45);  // fp = 40, tp = 45, cp = 55
                //            Product s5p5 = Sony.newProduct("s5p5",50, 65, 55);  // fp = 50, tp = 55, cp = 65
                //            Product s5p6 = Sony.newProduct("s5p6",60, 75, 65);  // fp = 60, tp = 65, cp = 75
                //            Product s5p7 = Sony.newProduct("s5p7",70, 85, 75);  // fp = 70, tp = 75, cp = 85
                //            Product s5p8 = Sony.newProduct("s5p8",80, 95, 85);  // fp = 80, tp = 85, cp = 95
                //            Product s5p9 = Sony.newProduct("s5p9",90, 105, 95); // fp = 90, tp = 95, cp = 105
                //            Product s5p10 = Sony.newProduct("s5p10",100, 115, 105); // fp = 100, tp = 105, cp = 115
                //            populateProductTable(Sony);
                //
                //            txtSalesPerson.setText("Sales person 5");
                //
                //            PersonDirectory pd = new PersonDirectory();
                //            Person p1=pd.newPerson("s5c1");
                //            Person p2=pd.newPerson("s5c2");
                //            Person p3=pd.newPerson("s5c3");
                //            Person p4=pd.newPerson("s5c4");
                //            Person p5=pd.newPerson("s5c5");
                //            Person p6=pd.newPerson("s5c6");
                //            Person p7=pd.newPerson("s5c7");
                //            Person p8=pd.newPerson("s5c8");
                //            Person p9=pd.newPerson("s5c9");
                //            Person p10=pd.newPerson("s5c10");
                //
                //            CustomerDirectory cs5 = new CustomerDirectory(b);
                //            cs5.newCustomerProfile(p1);
                //            cs5.newCustomerProfile(p2);
                //            cs5.newCustomerProfile(p3);
                //            cs5.newCustomerProfile(p4);
                //            cs5.newCustomerProfile(p5);
                //            cs5.newCustomerProfile(p6);
                //            cs5.newCustomerProfile(p7);
                //            cs5.newCustomerProfile(p8);
                //            cs5.newCustomerProfile(p9);
                //            cs5.newCustomerProfile(p10);
                //            populateCustomerTable(cs5);
                //        }
    }//GEN-LAST:event_dropdownSupplierActionPerformed


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PricingModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PricingModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PricingModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PricingModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PricingModel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdjust;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> dropdownSupplier;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblOrderItem;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTable tblOrderItems;
    private javax.swing.JTable tblProduct;
    private javax.swing.JLabel txtCustomer;
    // End of variables declaration//GEN-END:variables



    private void populateCustomerTable(CustomerDirectory cd) {
        DefaultTableModel model = (DefaultTableModel) tblCustomers.getModel();
        model.setRowCount(0);
        for (CustomerProfile c : cd.getCustomers()) {
            Object[] row = new Object[1];
            row[0] = c.getCustomerId();
            model.addRow(row);
        }
    }}


