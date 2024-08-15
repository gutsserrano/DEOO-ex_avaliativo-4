package model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Storage {

    private static Storage instance = null;

    private final List<Product> products;

    private Storage() {
        products = new ArrayList<>();
    }

    public static Storage getInstance(){
        if(instance == null){
            instance = new Storage();
        }
        return instance;
    }

    public Product findById(Long id){
        for(Product p : this.products){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    public void addProduct(Product p){
        this.products.add(p);
    }

     public void removeProduct(Long id){
        Product p = findById(id);
        if(p != null){
            synchronized(products){
                this.products.remove(p);
            }
        }
    }

    public void sellProduct(Long id, int quantity){
        Product p = findById(id);
        if(p != null){
            synchronized (products){
                p.decrementQuantity(quantity);
            }
        }
    }

}
