package zholud.homeworks.Users;

public class UserFileStorageConsoleApp extends FileStorageConsoleApp<User> {

    public UserFileStorageConsoleApp(String directory, Storage<User> fileStorage) {
        super(directory, fileStorage);
    }

    @Override
    User initialize() {
        System.out.println("Введите возраст");
        age = input.nextInt();
        System.out.println("Введите имя");
        name = input.next();
        System.out.println("Введите страну");
        country = input.next();
        System.out.println("Введите id");
        id = input.nextInt();
        input.nextLine();
        return new User(age, name, country, id);
    }
}
