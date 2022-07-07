package zholud.homeworks.Users;


public class UserFileStorage extends FileStorage<User> {

    @Override
    User deserialize(String[] itemArray) {
        return new User(Integer.parseInt(itemArray[0]), itemArray[1],
                itemArray[2], Integer.parseInt(itemArray[3]));
    }
}
