package zholud.homeworks.Users;

import java.io.IOException;

public interface Storage<T extends Writable> {

    /**
     * Создаёт файл и сохраняет туда объект
     *
     * @param directory директория, в которую сохраняется файл
     * @param item      сохраняемый объект
     * @return true - объект успешно сохранён, false - не удалось сохранить объект
     */
    String writeItem(String directory, T item) throws IOException;

    /**
     * Выводит данные объекта в консоль по имени файла
     *
     * @param directory директирия, в которой лежит файл
     * @param file      файл, из которого читается объект
     * @return данные объекта в виде массива
     */
    T printItem(String directory, String file) throws IOException, ClassNotFoundException;

    /**
     * Удаляет файл
     *
     * @param directory директория, в которой лежит файл
     * @param file      файл, который нужно удалить
     * @return файл
     */
    boolean deleteFile(String directory, String file);

    /**
     * Выводит в консоль все файлы в указанной директории
     *
     * @param directory директория из которой выводятся файлы
     * @return файлы, находящиеся в директории
     */
    String[] showFiles(String directory);
}
