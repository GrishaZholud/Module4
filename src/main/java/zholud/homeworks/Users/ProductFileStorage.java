package zholud.homeworks.Users;

public class ProductFileStorage extends FileStorage<Product> {
    @Override
    Product deserialize(String[] itemArray) {
        return new Product(Integer.parseInt(itemArray[0]), itemArray[1],
                itemArray[2], Integer.parseInt(itemArray[3]));
    }
}
