import a.Consumer;
import a.Provider;
import a.Store;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //消费者线程
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Store store = new Store(list);
        Thread consumer1 = new Thread(new Consumer(store, "消费者1",0));
        Thread consumer2 = new Thread(new Consumer(store, "消费者2",0));
        Thread consumer3 = new Thread(new Consumer(store, "消费者3",0));
        Thread provider1 = new Thread(new Provider(store, "生产者1"));
        Thread provider2 = new Thread(new Provider(store, "生产者2"));
        //生产者线程
        consumer1.start();
        consumer2.start();
        consumer3.start();
        provider1.start();
        provider2.start();
    }
}
