package koreatech.cse.domain.total;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Result {
    private Items items;

    @Override
    public String toString() {
        return "Result{" +
                "items=" + items +
                '}';
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
