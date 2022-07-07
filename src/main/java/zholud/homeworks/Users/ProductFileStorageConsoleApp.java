package zholud.homeworks.Users;

public class ProductFileStorageConsoleApp extends FileStorageConsoleApp<Product> {

    public ProductFileStorageConsoleApp(String directory, Storage<Product> fileStorage) {
        super(directory, fileStorage);
    }

    @Override
    Product initialize() {
        System.out.println("Введите срок годности");
        age = input.nextInt();
        System.out.println("Введите название");
        name = input.next();
        System.out.println("Введите страну изготовления");
        country = input.next();
        System.out.println("Введите id");
        id = input.nextInt();
        input.nextLine();
        return new Product(age, name, country, id);
    }
}
