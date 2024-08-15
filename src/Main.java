import model.entities.Product;
import model.entities.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Storage storage = Storage.getInstance();

        storage.addProduct(new Product("Toalha de mesa", 10, 39.99));
        storage.addProduct(new Product("Coberdrom", 12, 132.99));
        storage.addProduct(new Product("Lençol", 32, 249.99));

        List<Thread> threads = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 8; i++){
            Thread t = new Thread(){
                @Override
                public void run(){
                    Long value = random.nextLong(1, 4);
                    int quantity = random.nextInt(1, 8);
                    if(storage.sellProduct(value, quantity))
                        System.out.println(storage.findById(value).getName() + " vendido. Quantidade: " + quantity);
                    else
                        System.out.println(storage.findById(value).getName() + " não vendido por falta de estoque.");
                };

            };
            threads.add(t);
        }

        threads.forEach(Thread::start);

    }

}