package zholud.homeworks.Users;

import java.io.Serializable;

public class User implements Serializable, Writable {
    private int age;
    private String name;
    private String country;
    private int id;

    public User(int age, String name, String country, int id) {
        this.age = age;
        this.name = name;
        this.country = country;
        this.id = id;
    }

    public User(User user) {
        this.age = user.getAge();
        this.name = user.getName();
        this.country = user.getCountry();
        this.id = user.getId();
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
        return new User(age, name, country, id);
    }

    @Override
    public String getFilename() {
        return this.id + ".csv";
    }

}
