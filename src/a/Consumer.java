package a;


/**
 * @author:liu.yucheng
 * @Data:2019-3-22 10:13
 * @version:1.0
 */
public class Consumer implements Runnable {
    Store store;
    String name;
    int count;

    public Consumer(Store store, String name,int count) {
        this.store = store;
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (store) {
            while (true) {
                if (store.goodList.size() > 0) {
                    this.count++;
                    System.out.print(name + "消费了" + store.goodList.get(0)+"总消费"+count+"\n");
                    store.goodList.remove(0);
                    try {
                        Thread.sleep(0);
                        //释放锁
                        store.notifyAll();
                        //锁定
                        store.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        //唤醒生产者线程
                        store.notifyAll();
                        store.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
