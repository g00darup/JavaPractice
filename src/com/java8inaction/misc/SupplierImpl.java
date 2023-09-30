package com.java8inaction.misc;

import main.java.edu.java.lambda.functional.SupplierDemo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierImpl {
    public static void main(String[] args) {
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());
        Supplier<List<Product>> productSupplier = () ->  getProducts();
        System.out.println(productSupplier.get());
        }
    private static List<Product> getProducts() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Jhinga",250));
        productList.add(new Product(1, "Lowky",750));
        productList.add(new Product(1, "karela",1000));
        productList.add(new Product(1, "alo",2000));
        productList.add(new Product(1, "piaz",5000));
        return productList;
    }

    static class Product{
        private int id;
        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
        private String name;
        private float price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

    }
}
