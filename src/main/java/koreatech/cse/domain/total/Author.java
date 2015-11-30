package koreatech.cse.domain.total;



/**
 * Created by kth on 2015. 11. 30..
 */
public class Author {
    private String order;
    private String name;
    private String url;

    public Author() {
        this.order = null;
        this.name = null;
        this.url = null;
    }

    @Override
    public String toString() {
        return "Author{" +
                "order='" + order + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
