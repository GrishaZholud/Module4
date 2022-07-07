package zholud.homeworks.Users;

public interface Writable {
    /**
     * Возвращает имя файла указанного объекта
     *
     * @return файл
     */
    String getFilename();

    /**
     * возвращает данные объекта в виде строки
     *
     * @return строка из данных объекта
     */
    String toString();

    /**
     * Создает юзера с переданными значениями
     *
     * @param age     возраст юзера
     * @param name    имя юзера
     * @param country страна юзера
     * @param id      id юзера
     * @return созданный юзер
     */
    Writable writeItem(int age, String name, String country, int id);
}
