import model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class ShoppingStoreTest {
    ShoppingStore shoppingStore = new ShoppingStore();
    private final Product mobile = new Product("Mobile");
    private final Product windows = new Product("windows-laptop");
    private final Product mac = new Product("mac-laptop");

    @Before
    public void setUp() {
        shoppingStore.add(mobile);
        shoppingStore.add(windows);
        shoppingStore.add(mac);
    }

    @Test
    public void givenEmptyShoppingStore_whenFindByName_thenResultIsNotReturned() {
        //given
        shoppingStore = new ShoppingStore();

        //when
        List result = shoppingStore.findByName("xyz");

        //then
        Assert.assertEquals(0, result.size());

    }

    @Test
    public void givenNonEmptyShoppingStore_whenFindByName_thenProductIsReturned() {
        //when
        List result = shoppingStore.findByName("Mobile");

        //then
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void givenNonEmptyShoppingStore_whenFindByNamePartialMatch_thenProductIsReturned() {
        //when
        List<Product> result = shoppingStore.findByName("lap");

        //then
        Assert.assertEquals(2, result.size());
        Assert.assertThat(result, contains(windows, mac));
    }

    @Test
    public void givenNonEmptyShoppingStore_whenFindByNamePartialMatchCaseInSensitive_thenProductIsReturned() {
        //when
        List<Product> result = shoppingStore.findByName("LaP");

        //then
        Assert.assertEquals(2, result.size());
        Assert.assertThat(result, containsInAnyOrder(mac, windows));
    }
}
