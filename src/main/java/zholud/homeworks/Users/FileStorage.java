package zholud.homeworks.Users;

import java.io.*;

public abstract class FileStorage<T extends Writable> implements Storage<T> {
    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;

    @Override
    public String writeItem(String directory, T item) throws IOException {
        fileOutputStream = new FileOutputStream(directory + item.getFilename());
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(item.toString());
        fileOutputStream.close();
        return item.getFilename();
    }

    @Override
    public T printItem(String directory, String file) throws IOException, ClassNotFoundException {
        fileInputStream = new FileInputStream(directory + file);
        objectInputStream = new ObjectInputStream(fileInputStream);
        String line = (String) objectInputStream.readObject();
        String[] lines = line.split(" ");
        T item = deserialize(lines);
        fileInputStream.close();
        return item;
    }

    @Override
    public boolean deleteFile(String directory, String file) {
        File fileDeleted = new File(directory, file);
        return fileDeleted.delete();
    }

    @Override
    public String[] showFiles(String directory) {
        File file = new File(directory);
        String[] files = file.list();
        return files;
    }

    abstract T deserialize(String[] itemArray);
}
