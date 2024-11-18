/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */

public class ProductCatalog {
    private String type; // Catalog type (e.g., Electronics, Furniture, etc.)
    private ArrayList<Product> products; // List of products

    /**
     * Constructor to initialize the ProductCatalog with a type.
     * @param type Type of the catalog
     */
    public ProductCatalog(String type) {
        this.type = type;
        this.products = new ArrayList<>();  // Initialize the product list
    }

    /**
     * Default constructor with type "unknown".
     */
    public ProductCatalog() {
        this.type = "unknown";
        this.products = new ArrayList<>();
    }

    /**
     * Adds a new product without a name.
     * @param fp Floor price
     * @param cp Ceiling price
     * @param tp Target price
     * @return Created Product
     * @throws IllegalArgumentException if any price is negative
     */
    public Product newProduct(int fp, int cp, int tp) {
        if (fp < 0 || cp < 0 || tp < 0) {
            throw new IllegalArgumentException("Prices cannot be negative.");
        }
        Product p = new Product(fp, cp, tp);
        this.products.add(p);
        return p;
    }

    /**
     * Adds a new product with a name.
     * @param name Name of the product
     * @param fp Floor price
     * @param cp Ceiling price
     * @param tp Target price
     * @return Created Product
     * @throws IllegalArgumentException if product name is empty or any price is negative
     */
    public Product newProduct(String name, int fp, int cp, int tp) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name is required.");
        }
        if (fp < 0 || cp < 0 || tp < 0) {
            throw new IllegalArgumentException("Prices cannot be negative.");
        }
        Product p = new Product(name, fp, cp, tp);
        this.products.add(p);
        return p;
    }

    /**
     * Generates a report of all product performance in the catalog.
     * @return ProductsReport
     */
    public ProductsReport generatProductPerformanceReport() {
        ProductsReport productsReport = new ProductsReport();

        for (Product p : products) {
            ProductSummary ps = new ProductSummary(p);
            productsReport.addProductSummary(ps);
        }
        return productsReport;
    }

    /**
     * Returns the list of products in the catalog.
     * @return ArrayList<Product>
     */
    public ArrayList<Product> getProductList() {
        return this.products;
    }

    /**
     * Prints the details of all products in the catalog.
     */
    public void printCatalog() {
        System.out.println("Catalog Type: " + this.type);
        for (Product product : this.products) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        // Static Product Initialization Example
        ProductCatalog electronicsCatalog = new ProductCatalog("Electronics");
        electronicsCatalog.newProduct("Laptop", 1000, 1500, 1200);
        electronicsCatalog.newProduct("Smartphone", 800, 1300, 1000);
        electronicsCatalog.newProduct("Tablet", 600, 1000, 800);

        System.out.println("Static Product Initialization:");
        electronicsCatalog.printCatalog();

        // Dynamic Product Initialization Example (Simulating External Source)
        ProductCatalog importedCatalog = new ProductCatalog("Imported Products");
        String[][] externalProductData = {
            {"Chair", "50", "100", "75"},
            {"Desk", "100", "200", "150"},
            {"Lamp", "30", "80", "60"}
        };

        for (String[] productData : externalProductData) {
            importedCatalog.newProduct(productData[0],
                    Integer.parseInt(productData[1]),
                    Integer.parseInt(productData[2]),
                    Integer.parseInt(productData[3]));
        }

        System.out.println("\nDynamic Product Initialization:");
        importedCatalog.printCatalog();
    }

    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}