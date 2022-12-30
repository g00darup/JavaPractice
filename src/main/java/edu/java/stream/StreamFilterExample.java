package main.java.edu.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {
    public static void main(String[] args) {
    List<Product> list = new ArrayList<Product>();

    for(Product product: getProducts()){
        if (product.getPrice() > 500f) {
            list.add(product);
        }
    }
    list.forEach(p-> System.out.println(p));

    //using stream api
        List<Product> listProd = getProducts().stream().filter(product -> product.getPrice()>500f).collect(Collectors.toList());
        listProd.forEach(System.out::println);
    }

    private static List<Product> getProducts(){
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "HP Laptop", 440.55f));
        productList.add(new Product(2, "Dell Laptop", 340.55f));
        productList.add(new Product(3, "Sony Laptop", 670.75f));
        productList.add(new Product(4, "Lenovo Laptop", 540.25f));
        productList.add(new Product(5, "Apple Laptop", 740.78f));

        return productList;
    }
}

class Product {
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

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private int id;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    private String name;
    private float price;
}