package koreatech.cse.domain.total;

import java.util.List;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Items {
    private List<Item> items;

    @Override
    public String toString() {
        return "Items{" +
                "items=" + items +
                '}';
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Items() {
        this.items = null;
    }
}
