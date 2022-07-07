package zholud.homeworks.Users;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FileStorageConsoleApp<T extends Writable> {
    private static final Logger LOGGER = Logger.getLogger(UserFileStorage.class.getName());

    protected int age;
    protected String name;
    protected String country;
    protected int id;
    protected final Scanner input = new Scanner(System.in);

    private final String directory;
    Storage<T> fileStorage;

    public FileStorageConsoleApp(String directory, Storage<T> fileStorage) {
        this.directory = directory;
        this.fileStorage = fileStorage;
    }

    public void application() {
        while (true) {
            showMenu();
            String action = input.nextLine();
            switch (action) {
                case "1":
                    saveItem();
                    break;
                case "2":
                    showItem();
                    break;
                case "3":
                    deleteFile();
                    break;
                case "4":
                    showFiles();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Было введено неверное значение");
            }
        }
    }

    abstract T initialize();

    private void showMenu() {
        System.out.println(
                "1. ввести сущность и сохранить в файл, программа даст название файла\n" +
                        "2. ввести имя файла и прочитать из него сущность\n" +
                        "3. удалить файл\n" +
                        "4. посмотреть список файлов\n" +
                        "0. выйти из меню"
        );
    }

    private void saveItem() {
        T item = initialize();
        try {
            fileStorage.writeItem(directory, item);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Incorrect data entered", e);
        }
        LOGGER.info("File " + item.getFilename() + " created");
    }

    private void showItem() {
        try {
            System.out.println("Введите имя файла из которого хотите прочитать сущность");
            String file = input.nextLine();
            T item = fileStorage.printItem(directory, file);
            System.out.println(item.toString());
            LOGGER.info("File " + item.getFilename() + " printed");
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.WARNING, "File not found", e);
        }
    }

    private void deleteFile() {
        System.out.println("Введите имя файла, который хотите удалить");
        String file = input.nextLine();
        if (fileStorage.deleteFile(directory, file) == true) {
            LOGGER.info("File " + file + " deleted");
        } else {
            LOGGER.info("File " + file + " not found");
        }
    }

    private void showFiles() {
        String[] files = fileStorage.showFiles(directory);
        for (String file : files) {
            System.out.println(file);
        }
    }
}
