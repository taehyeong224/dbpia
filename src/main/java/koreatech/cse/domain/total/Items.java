package koreatech.cse.domain.total;

import java.util.List;
import koreatech.cse.domain.total.Item;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Items {
    private List<Item> item;

    public String toString() {
        return "Items{item=" + this.item + '}';
    }

    public List<Item> getItem() {
        return this.item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}