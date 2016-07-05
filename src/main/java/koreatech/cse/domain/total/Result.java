package koreatech.cse.domain.total;

import koreatech.cse.domain.total.Items;

public class Result {
    private Items items;

    public String toString() {
        return "Result{items=" + this.items + '}';
    }

    public Items getItems() {
        return this.items;
    }

    public Result(Items items) {
        this.items = items;
    }

    public Result() {
        this.items = null;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}