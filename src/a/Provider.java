package a;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

/**
 * @author:liu.yucheng
 * @Data:2019-3-22 10:05
 * @version:1.0
 */
public class Provider implements Runnable  {
    Store store;
    String providerName;
    Integer count = 9 ;

    public Provider(Store store,String providerName) {
        this.store = store;
        this.providerName = providerName;
    }
    @Override
    public void run() {
        //同步锁
        synchronized (store) {
            while (true) {
                if (store.goodList.size() <= 0) {
                    System.out.print("当前被消费完了\n");
                    int now = ++store.count;
                    store.goodList.add(now);
                    System.out.print(providerName+"新增一个商品" + now + "\n");
                    try{
                        store.notifyAll();
                        store.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } else {
                    try {
                        //释放锁
                        store.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
