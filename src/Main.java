import model.entities.Product;
import model.entities.Storage;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Storage storage = Storage.getInstance();

        storage.addProduct(new Product("Toalha de mesa", 10, 39.99));
        storage.addProduct(new Product("Coberdrom", 12, 132.99));
        storage.addProduct(new Product("Lençol", 32, 249.99));

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            Thread t = new Thread(){
                @Override
                public void run(){
                    storage.sellProduct(1L, 3);
                    System.out.println(storage.findById(1L));
                };

            };
            threads.add(t);
        }

        threads.forEach(Thread::start);


    }

}