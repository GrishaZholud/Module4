package zholud.homeworks.Users;

import java.io.Serializable;

public class Product implements Serializable, Writable {
    private int age;
    private String name;
    private String country;
    private int id;

    public Product(int age, String name, String country, int id) {
        this.age = age;
        this.name = name;
        this.country = country;
        this.id = id;
    }

    public Product(Product product) {
        this.age = product.getAge();
        this.name = product.getName();
        this.country = product.getCountry();
        this.id = product.getId();
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return age + " " + name + " " + country + " " + id;
    }

    @Override
    public Writable writeItem(int age, String name, String country, int id) {
        return new Product(age, name, country, id);
    }

    @Override
    public String getFilename() {
        return this.id + ".csv";
    }

}
