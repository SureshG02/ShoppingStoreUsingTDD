import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingStore {
  private List<Product> productList = new ArrayList<Product>();

    public List findByName(String name) {
        List<Product> result = new ArrayList<Product>();
        for(Product product: productList) {
            if(product.getName().toUpperCase().contains(name.toUpperCase())) {
                result.add(product);
            }
        }
        return result;
    }

    public List add(Product product) {
        if(product != null) {
            productList.add(product);
        }
        return productList;
    }

    public boolean isEmpty() {
        return productList.size() == 0;
    }
}
