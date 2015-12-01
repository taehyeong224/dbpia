package koreatech.cse.domain.total;

import java.util.List;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Items {
    private List<Item> item;

    @Override
    public String toString() {
        return "Items{" +
                "item=" + item +
                '}';
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
