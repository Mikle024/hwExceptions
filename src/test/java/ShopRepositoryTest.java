import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product item1 = new Product(1, "Хлеб", 20);
    Product item2 = new Product(2, "Сыр", 100);
    Product item3 = new Product(3, "Молоко", 50);
    ShopRepository repo = new ShopRepository();

    @Test
    public void shouldRemoveByIdTest() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.removeById(2);

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByIdTest() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }

    @Test
    public void addSuccessTest() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addNotSuccessTest() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(item2);
        });

    }
}
