package a;

import java.util.List;

/**
 * @author:liu.yucheng
 * @Data:2019-3-22 13:54
 * @version:1.0
 */
public class Store {
    List<Integer> goodList;
    int count = 9;

    public List<Integer> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Integer> goodList) {
        this.goodList = goodList;
    }

    public Store(List<Integer> goodList) {
        this.goodList = goodList;
    }
}
